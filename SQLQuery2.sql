
use MangerViking_Internet;
go
create table Member(
ID_Member char(4) primary key not null,

Name_Member varchar(30) not null,
PassWord varchar(30) not null,
TotalWorkingTime int,
Salary money
);

create table Computer(
ID_Computer char(4) primary key not null,
Status bit,
);

create table Bill(
ID_Computer char(4) not null foreign key references Computer(ID_Computer),
ID_Bill char(4)  primary key not null,
Timecheckin datetime ,
Timecheckout datetime,
ID_Member char(4) not null foreign key references Member(ID_Member),
Name_Member varchar(30),
Price_Food money,
Total money not null
);
create table Food(
ID_Food char(4) not null primary key,
Name_Product varchar(30),
Price_Food money
);
create table Food_Bill(
ID_Food char(4) not null foreign key references Food(ID_Food),
ID_Bill char(4) not null foreign key references Bill(ID_Bill),
Quantity char(4)
);
create table Salary(
ID_Salary char(4) not null primary key,
ID_Member char(4) foreign key references Member(ID_Member),
WorkDate date,
TimeCheckIn datetime,
TimeCheckOut datetime,
Total_hours_worked datetime,
Salary money

);
create table Revenue(
Total_revenue_of_the_day money,
Total_revenue_of_the_month money,
Total_revenue_of_the_quarter money,
Total_revenue_of_the_year money
);
create table Permission (
ID_Permission char(4) primary key,
Try_Permission varchar(30),

);
alter table [dbo].Member add 
[ID_Permission] char(4) null
go

insert into dbo.Permission(ID_Member, Name_Member, PassWord) values ('01', 'thu huyen', '0123');
SELECT * FROM Permission

