create table users( 
 username varchar(50) not null primary key, 
 password varchar(100) not null, 
 enabled boolean not null 
); 

create table authorities ( 
 username varchar(50) not null, 
 authority varchar(50) not null, 
 constraint fk_authorities_users foreign key(username) references 
users(username) 
); 

create unique index ix_auth_username on authorities (username,authority); 

#Insert login information into database tables. 
insert into users(username,password,enabled) 
 values('admin','$2a$10$gHEgXrzE3TPgElfOcCmd7OSzUhUsYTXQcNl96LqkF0yfSRKKnXUva',true); 
 
insert into authorities(username,authority) 
 values('admin','ROLE_ADMIN'); 
 
# REMINDER 
#Before inserting data into tables, you can use the following code to encrypt the password. 
#String encoded=new BCryptPasswordEncoder().encode("admin@123");