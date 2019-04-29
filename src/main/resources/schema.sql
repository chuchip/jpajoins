create table article
(
	 id integer not null,
	 description varchar(50) not null,
	 price decimal(10,3),
	 primary key(id)
);
create table customer
(
	 id integer not null,
	 name varchar(50) not null,
	 address varchar(100),
	 active int not null,
	 primary key(id)
);
create table invoiceHeader
(
	 id integer not null,
	 fiscalYear  int  not null,
	 numberInvoice int not null,
	 customerId int not null,
	 active char(1),
	 primary key(id),
	 UNIQUE  (fiscalYear,numberInvoice)
);
create table invoiceDetails
(
	 id integer not null,
	 fiscalYear  int  not null,
	 numberInvoice int not null,
	 linea_details int not null,
	 numberArticles int not null,
	 articleId int not null,
	 primary key(id),
	 UNIQUE (fiscalYear,numberInvoice,linea_details )
);
alter  table invoiceHeader add constraint invoiceHConstraint FOREIGN KEY (customerId) references customer(id);
alter  table invoiceDetails add constraint invoiceDConstraint1 FOREIGN KEY (fiscalYear, numberInvoice) references invoiceHeader(fiscalYear,numberInvoice);
alter  table invoiceDetails add constraint invoiceDConstraint2 FOREIGN KEY (articleId) references article(id);


