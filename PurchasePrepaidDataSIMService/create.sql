create table customers (id bigint not null auto_increment, name varchar(200), phone_number varchar(13), primary key (id)) engine=InnoDB
create table history_purchase (id bigint not null auto_increment, customers_id bigint, primary key (id)) engine=InnoDB
create table type_voucher (id bigint not null auto_increment, capacity varchar(200), date_expire date, price integer, status integer, name varchar(200), primary key (id)) engine=InnoDB
alter table customers add constraint UK_6v6x92wb400iwh6unf5rwiim4 unique (phone_number)
alter table history_purchase add constraint FKp8xhm9a87ntskniw3epx41jrg foreign key (customers_id) references customers (id)
create table customers (id bigint not null auto_increment, name varchar(200), phone_number varchar(13), primary key (id)) engine=InnoDB
create table history_purchase (id bigint not null auto_increment, customers_id bigint, primary key (id)) engine=InnoDB
create table type_voucher (id bigint not null auto_increment, capacity varchar(200), date_expire date, price integer, status integer, name varchar(200), primary key (id)) engine=InnoDB
alter table customers add constraint UK_6v6x92wb400iwh6unf5rwiim4 unique (phone_number)
alter table history_purchase add constraint FKp8xhm9a87ntskniw3epx41jrg foreign key (customers_id) references customers (id)

    create table customers (
       id bigint not null auto_increment,
        name varchar(200),
        phone_number varchar(13),
        primary key (id)
    ) engine=InnoDB

    create table history_purchase (
       id bigint not null auto_increment,
        customers_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table type_voucher (
       id bigint not null auto_increment,
        capacity varchar(200),
        date_expire date,
        price integer,
        status integer,
        name varchar(200),
        primary key (id)
    ) engine=InnoDB

    alter table customers 
       add constraint UK_6v6x92wb400iwh6unf5rwiim4 unique (phone_number)

    alter table history_purchase 
       add constraint FKp8xhm9a87ntskniw3epx41jrg 
       foreign key (customers_id) 
       references customers (id)
