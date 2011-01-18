package cn.edu.sjtu.common.utils;

public class Base64 {

	// ~ Static fields/initializers /////////////////////////////////////////////

  // BASE64 encode_table
  private final static char[] ENC_TABLE = {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
      'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
      'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
      'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
      '4', '5', '6', '7', '8', '9', '+', '/'
  };

  // BASE64 decode_table
  private final static byte[] DEC_TABLE = {
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57,
      58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
      10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1,
      -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
      40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1,
  };

	// ~ Methods ////////////////////////////////////////////////////////////////

	public static byte[] decode(byte[] data) {
		int padCount = 0;
		int i;
		int len = data.length;
		int realLen = 0;

		for (i = len - 1; i >= 0; --i) {
			if (data[i] > ' ') {
				realLen++;
			}

			if (data[i] == 0x3D) {
				padCount++;
			}
		}

		if ((realLen % 4) != 0) {
			throw new IllegalArgumentException("Length not a multiple of 4");
		}

		int retLen = ((realLen / 4) * 3) - padCount;
		byte[] ret = new byte[retLen];

		i = 0;

		byte[] t = new byte[4];
		int outputIndex = 0;
		int j = 0;
		t[0] = t[1] = t[2] = t[3] = 0x3D;

		while (i < len) {
			byte c = data[i++];

			if (c > ' ') {
				t[j++] = c;
			}

			if (j == 4) {
				outputIndex += decode(ret, outputIndex, t[0], t[1], t[2], t[3]);
				j = 0;
				t[0] = t[1] = t[2] = t[3] = 0x3D;
			}
		}

		if (j > 0) {
			decode(ret, outputIndex, t[0], t[1], t[2], t[3]);
		}

		return ret;
	}

	public static int decode(byte[] ret, int retOff, byte a, byte b, byte c, byte d) {
		byte da = DEC_TABLE[a];
		byte db = DEC_TABLE[b];
		byte dc = DEC_TABLE[c];
		byte dd = DEC_TABLE[d];

		if ((da == -1) || (db == -1) || ((dc == -1) && (c != 0x3D)) || ((dd == -1) && (d != 0x3D))) {
			throw new IllegalArgumentException("Invalid character [" + (a & 0xFF) + ", " + (b & 0xFF) + ", " + (c & 0xFF) + ", " + (d & 0xFF) + "]");
		}

		ret[retOff++] = (byte) ((da << 2) | db >>> 4);

		if (c == 0x3D) {
			return 1;
		}

		ret[retOff++] = (byte) ((db << 4) | dc >>> 2);

		if (d == 0x3D) {
			return 2;
		}

		ret[retOff++] = (byte) ((dc << 6) | dd);

		return 3;
	}

	public static byte[] encode(byte[] data) {
		int i = 0;
		int j = 0;
		int len = data.length;
		int delta = len % 3;
		int outlen = (((len + 2) / 3) * 4) + ((len == 0) ? 2 : 0);
		byte[] output = new byte[outlen];

		byte a;
		byte b;
		byte c;

		for (int count = len / 3; count > 0; count--) {
			a = data[i++];
			b = data[i++];
			c = data[i++];
			output[j++] = (byte) (ENC_TABLE[(a >>> 2) & 0x3F]);
			output[j++] = (byte) (ENC_TABLE[((a << 4) & 0x30) + ((b >>> 4) & 0x0F)]);
			output[j++] = (byte) (ENC_TABLE[((b << 2) & 0x3C) + ((c >>> 6) & 0x03)]);
			output[j++] = (byte) (ENC_TABLE[c & 0x3F]);
		}

		if (delta == 1) {
			a = data[i++];
			output[j++] = (byte) (ENC_TABLE[(a >>> 2) & 0x3F]);
			output[j++] = (byte) (ENC_TABLE[((a << 4) & 0x30)]);
			output[j++] = (byte) '=';
			output[j++] = (byte) '=';
		} else if (delta == 2) {
			a = data[i++];
			b = data[i++];
			output[j++] = (byte) (ENC_TABLE[(a >>> 2) & 0x3F]);
			output[j++] = (byte) (ENC_TABLE[((a << 4) & 0x30) + ((b >>> 4) & 0x0F)]);
			output[j++] = (byte) (ENC_TABLE[((b << 2) & 0x3C)]);
			output[j++] = (byte) '=';
		}

		if (j != outlen) {
			throw new IllegalArgumentException("output length was not the expected");
		}

		return output;
	}

}
