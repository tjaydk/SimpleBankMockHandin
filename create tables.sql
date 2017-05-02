DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Account;

create table Customer (
	cust_id SMALLINT NOT NULL AUTO_INCREMENT,
    first_name varchar(20),
    last_name varchar(20),
    age int(2),
    primary key (cust_id)
);

create table Account (
	account_id SMALLINT NOT NULL AUTO_INCREMENT,
    cust_id SMALLINT NOT NULL,
    balance double(10,2),
    PRIMARY KEY (account_id),
    FOREIGN KEY (cust_id)
		REFERENCES Customer(cust_id)
        ON DELETE CASCADE
);