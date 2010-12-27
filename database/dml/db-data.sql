insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('闵行店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('徐汇店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('黄浦店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('普陀店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('闸北店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('杨浦店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_store(store_name, status, create_by, create_date, modify_by, modify_date) 
	values('浦东店', 'OPEN', 'admin', '2010-1-14', 'admin', '2010-1-14');

insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('jim', '123456', '江凌俊', 'jim.jiang@digitas.com', 'ACTIVE', 1, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('cdh', '123456', '崔东浩', '', 'ACTIVE', 2, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('shl', '123456', '桑会兰', '', 'ACTIVE', 3, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('gxb', '123456', '郭学兵', '', 'ACTIVE', 4, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('tj', '123456', '汤杰', '', 'ACTIVE', 5, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('ht', '123456', '华天', '', 'ACTIVE', 6, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('sy', '123456', '苏岩', '', 'ACTIVE', 7, 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_user(login_name, password, name, email, status, store_id, create_by, create_date, modify_by, modify_date) 
	values('rrn', '123456', '饶若楠', '', 'ACTIVE', 2, 'admin', '2010-1-14', 'admin', '2010-1-14');
	
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787111186823', 'UML和模式应用（原书第3版）', '拉曼', '机械工业出版社', '2006-5-1', '66.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115171733', 'Excel 应用大全', 'Excel Home', '人民邮电出版社', '2008-3-1', '88.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115145543', 'C++ Primer中文版(第4版）', 'Stanley', '人民邮电出版社', '2006-3-1', '99.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115183729', 'Adobe Photoshop CS3中文版经典教程', '美国Adobe公司', '人民邮电出版社', '2008-10-1', '39.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787121053863', '计算机网络（第5版）', '谢希仁', '电子工业出版社', '2008-1-1', '35.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787302108535', 'C程序设计（第三版）', '谭浩强', '清华大学出版社', '2005-7-1', '26.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787111213826', 'Java编程思想（第4版）', '埃克尔', '机械工业出版社', '2007-6-1', '108.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787506345040', '好妈妈胜过好老师', '尹建莉', '作家出版社', '2010-1-1', '28.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787561348819', '易经的奥秘', '曾仕强', '陕西师范大学出版社', '2010-11-1', '30.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787506345040', '手到病自除', '杨奕', '江苏人民出版社', '2010-8-1', '29.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787508616780', '世界因你不同——李开复自传', '李开复，范海涛', '中信出版社', '2010-9-1', '29.80');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787561345948', '不抱怨的世界', '鲍温', '陕西师范大学出版社', '2010-4-1', '24.80');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787535435828', '蜗居', '六六', '长江文艺出版社', '2007-12-1', '25.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787530209981', '张爱玲全集：小团圆（张爱玲最神秘小说遗稿）', '张爱玲', '北京十月文艺出版社', '2010-4-1', '28.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787533148041', '力量与肌肉训练图谱', '马克·韦勒', '山东科学技术出版社', '2008-1-1', '39.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787802433588', '不可思议的纸飞机', '王勋邦', '航空工业出版社', '2010-8-1', '25.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787121065392', '走出软件作坊(IT人升职必备)', '阿朱', '电子工业出版社', '2010-1-1', '39.80');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115182623', '嵌入式Linux应用开发完全手册', '韦东山', '人民邮电出版社', '2008-8-1', '69.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115147318', 'UNIX环境高级编程（第2版）', '史蒂文斯', '人民邮电出版社', '2006-5-1', '99.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787508353937', 'Head First 设计模式（中文版）', '弗里曼', '中国电力出版社', '2007-9-1', '98.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787111262817', 'PHP和MySQL Web开发 （原书第4版）', '威利', '机械工业出版社', '2010-4-1', '95.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115215147', 'Oracle性能诊断艺术', '安东尼尼', '人民邮电出版社', '2010-10-1', '75.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787115195999', 'jQuery实战', '比伯奥特', '人民邮电出版社', '2010-2-1', '49.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787302184959', 'C#高级编程(第6版)', '内格尔', '清华大学出版社', '2008-10-1', '158.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313055392', '自动控制原理习题精解与考研指导', '徐薇莉', '上海交通大学出版社', '2010-3-1', '29.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313041111', '软件开发项目管理', '栾跃', '上海交通大学出版社', '2005-8-1', '68.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313045942', '社会智能科学', '戴汝为', '上海交通大学出版社', '2007-1-1', '40.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313041661', '空间数据库索引技术', '郭薇', '上海交通大学出版社', '2006-4-1', '24.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313055026', '管理系统中的计算机应用', '鼓连刚,张震', '上海交通大学出版社', '2008-12-1', '28.00');
insert into t_book(isbn_no, book_name, author, publisher, publish_date, price) 
	values('9787313044327', '软件质量保证技术（三级）', '李正海', '上海交通大学出版社', '2006-7-1', '28.00');
	
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(1, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(2, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(2, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(3, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(3, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(4, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(4, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(5, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(5, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(6, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(6, 30, '2010-1-14', 100);

insert into t_store_repository(store_id, book_id, `date`, num) values(7, 1, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 2, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 3, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 4, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 5, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 6, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 7, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 8, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 9, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 10, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 11, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 12, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 13, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 14, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 15, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 16, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 17, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 18, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 19, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 20, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 21, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 22, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 23, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 24, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 25, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 26, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 27, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 28, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 29, '2010-1-14', 100);
insert into t_store_repository(store_id, book_id, `date`, num) values(7, 30, '2010-1-14', 100);
	
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 2, '2010-1-22', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-14', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-15', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-16', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-17', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-18', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-19', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-20', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-21', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 3, '2010-1-22', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-14', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-15', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-16', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-17', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-18', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-19', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-20', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-21', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 4, '2010-1-22', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-14', 10, 350.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-15', 5, 175.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-16', 10, 350.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-17', 5, 175.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-18', 10, 350.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-19', 5, 175.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-20', 10, 350.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-21', 5, 175.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 5, '2010-1-22', 10, 350.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-14', 10, 260.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-15', 5, 130.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-16', 10, 260.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-17', 5, 130.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-18', 10, 260.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-19', 5, 130.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-20', 10, 260.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-21', 5, 130.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 6, '2010-1-22', 10, 260.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-14', 10, 1080.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-15', 5, 540.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-16', 10, 1080.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-17', 5, 540.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-18', 10, 1080.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-19', 5, 540.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-20', 10, 1080.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-21', 5, 540.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 7, '2010-1-22', 10, 1080.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-14', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-15', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-16', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-17', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-18', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-19', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-20', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-21', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 8, '2010-1-22', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-14', 10, 300.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-15', 5, 150.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-16', 10, 300.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-17', 5, 150.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-18', 10, 300.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-19', 5, 150.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-20', 10, 300.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-21', 5, 150.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 9, '2010-1-22', 10, 300.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-14', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-15', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-16', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-17', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-18', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-19', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-20', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-21', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 10, '2010-1-22', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-14', 10, 298.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-15', 5, 149.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-16', 10, 298.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-17', 5, 149.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-18', 10, 298.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-19', 5, 149.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-20', 10, 298.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-21', 5, 149.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 11, '2010-1-22', 10, 298.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-14', 10, 248.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-15', 5, 124.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-16', 10, 248.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-17', 5, 124.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-18', 10, 248.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-19', 5, 124.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-20', 10, 248.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-21', 5, 124.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 12, '2010-1-22', 10, 248.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-14', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-15', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-16', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-17', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-18', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-19', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-20', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-21', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 13, '2010-1-22', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-14', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-15', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-16', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-17', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-18', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-19', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-20', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-21', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 14, '2010-1-22', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-14', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-15', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-16', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-17', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-18', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-19', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-20', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-21', 5, 195.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 15, '2010-1-22', 10, 390.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-14', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-15', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-16', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-17', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-18', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-19', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-20', 10, 250.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-21', 5, 125.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 16, '2010-1-22', 10, 250.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-14', 10, 398.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-15', 5, 199.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-16', 10, 398.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-17', 5, 199.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-18', 10, 398.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-19', 5, 199.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-20', 10, 398.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-21', 5, 199.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 17, '2010-1-22', 10, 398.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-14', 10, 690.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-15', 5, 345.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-16', 10, 690.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-17', 5, 345.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-18', 10, 690.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-19', 5, 345.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-20', 10, 690.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-21', 5, 345.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 18, '2010-1-22', 10, 690.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-14', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-15', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-16', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-17', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-18', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-19', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-20', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-21', 5, 495.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 19, '2010-1-22', 10, 990.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-14', 10, 980.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-15', 5, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-16', 10, 980.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-17', 5, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-18', 10, 980.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-19', 5, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-20', 10, 980.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-21', 5, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 20, '2010-1-22', 10, 980.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-14', 10, 950.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-15', 5, 475.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-16', 10, 950.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-17', 5, 475.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-18', 10, 950.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-19', 5, 475.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-20', 10, 950.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-21', 5, 475.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 21, '2010-1-22', 10, 950.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-14', 10, 750.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-15', 5, 375.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-16', 10, 750.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-17', 5, 375.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-18', 10, 750.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-19', 5, 375.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-20', 10, 750.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-21', 5, 375.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 22, '2010-1-22', 10, 750.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-14', 10, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-15', 5, 245.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-16', 10, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-17', 5, 245.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-18', 10, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-19', 5, 245.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-20', 10, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-21', 5, 245.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 23, '2010-1-22', 10, 490.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-14', 10, 1580.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-15', 5, 790.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-16', 10, 1580.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-17', 5, 790.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-18', 10, 1580.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-19', 5, 790.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-20', 10, 1580.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-21', 5, 790.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 24, '2010-1-22', 10, 1580.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-14', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-15', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-16', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-17', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-18', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-19', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-20', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-21', 5, 145.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 25, '2010-1-22', 10, 290.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-14', 10, 680.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-15', 5, 340.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-16', 10, 680.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-17', 5, 340.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-18', 10, 680.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-19', 5, 340.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-20', 10, 680.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-21', 5, 340.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 26, '2010-1-22', 10, 680.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-14', 10, 400.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-15', 5, 200.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-16', 10, 400.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-17', 5, 200.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-18', 10, 400.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-19', 5, 200.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-20', 10, 400.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-21', 5, 200.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 27, '2010-1-22', 10, 400.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-14', 10, 240.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-15', 5, 120.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-16', 10, 240.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-17', 5, 120.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-18', 10, 240.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-19', 5, 120.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-20', 10, 240.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-21', 5, 120.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 28, '2010-1-22', 10, 240.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-14', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-15', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-16', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-17', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-18', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-19', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-20', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-21', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 29, '2010-1-22', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-14', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-15', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-16', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-17', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-18', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-19', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-20', 10, 280.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-21', 5, 140.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(1, 30, '2010-1-22', 10, 280.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(2, 2, '2010-1-22', 10, 880.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(3, 2, '2010-1-22', 10, 880.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(4, 2, '2010-1-22', 10, 880.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(5, 2, '2010-1-22', 10, 880.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(6, 2, '2010-1-22', 10, 880.00);

insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-14', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-15', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-16', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-17', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-18', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-19', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-20', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-21', 5, 330.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 1, '2010-1-22', 10, 660.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-14', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-15', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-16', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-17', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-18', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-19', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-20', 10, 880.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-21', 5, 440.00);
insert into t_store_book_sell(store_id, book_id, sale_date, sale_num, sale_total) values(7, 2, '2010-1-22', 10, 880.00);

insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010001', 1, 'PENDING', 'FINISHED', 100, 7700.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(1, 1, 50, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(1, 2, 50, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010002', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(2, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010003', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(3, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010004', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(4, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010005', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(5, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010006', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(6, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010007', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(7, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010008', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(8, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010009', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(9, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010010', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(10, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010011', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(11, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(11, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010012', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(12, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010013', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(13, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010014', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(14, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010015', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(15, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010016', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(16, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(16, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010017', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(17, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010018', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(18, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010019', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(19, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010020', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(20, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010021', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(21, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(21, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010022', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(22, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010023', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(23, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010024', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(24, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010025', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(25, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010026', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(26, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(26, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010027', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(27, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010028', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(28, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010029', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(29, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010030', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(30, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010031', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(31, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(31, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010032', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(32, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010033', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(33, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010034', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(34, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010035', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(35, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010036', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(36, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(36, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010037', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(37, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010038', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(38, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010039', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(39, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010040', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(40, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010041', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(41, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(41, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010042', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(42, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010043', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(43, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010044', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(44, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010045', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(45, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010046', 1, 'PENDING', 'FINISHED', 50, 3850.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(46, 1, 25, 66.00);
insert into t_order01_detail(order_id, book_id, num, price) values(46, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010047', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(47, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010048', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(48, 2, 25, 88.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010049', 1, 'PENDING', 'FINISHED', 25, 1650.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(49, 1, 25, 66.00);
insert into t_order01(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('1000010050', 1, 'PENDING', 'FINISHED', 25, 2200.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order01_detail(order_id, book_id, num, price) values(50, 2, 25, 88.00);

insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010001', 1, 'REVIEW', 'WAITING', 50, 3850.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(1, 1, 25, 66.00);
insert into t_order02_detail(order_id, book_id, num, price) values(1, 2, 25, 88.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010002', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(2, 1, 25, 66.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010003', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(3, 2, 25, 88.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010004', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(4, 1, 25, 66.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010005', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(5, 2, 25, 88.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010006', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(6, 1, 25, 66.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010007', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(7, 2, 25, 88.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010008', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(8, 1, 25, 66.00);
insert into t_order02(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('2000010009', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order02_detail(order_id, book_id, num, price) values(9, 2, 25, 88.00);

insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010001', 1, 'REVIEW', 'WAITING', 50, 3850.00, '2010-1-14', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(1, 1, 25, 66.00);
insert into t_order03_detail(order_id, book_id, num, price) values(1, 2, 25, 88.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010002', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-15', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(2, 1, 25, 66.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010003', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-16', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(3, 2, 25, 88.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010004', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-17', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(4, 1, 25, 66.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010005', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-18', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(5, 2, 25, 88.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010006', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-19', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(6, 1, 25, 66.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010007', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-20', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(7, 2, 25, 88.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010008', 1, 'REVIEW', 'WAITING', 25, 1650.00, '2010-1-21', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(8, 1, 25, 66.00);
insert into t_order03(order_no, store_id, status, sync_flag, num, total_price, order_date, create_by, create_date, modify_by, modify_date) 
	values('3000010009', 1, 'REVIEW', 'WAITING', 25, 2200.00, '2010-1-22', 'admin', '2010-1-14', 'admin', '2010-1-14');
insert into t_order03_detail(order_id, book_id, num, price) values(9, 2, 25, 88.00);
