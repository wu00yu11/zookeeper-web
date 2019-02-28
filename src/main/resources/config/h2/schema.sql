CREATE TABLE user_info (
  id int(11)  auto_increment PRIMARY KEY,
  user_name varchar(32),
  pass_word varchar(32),
  user_type varchar(2),
  enabled int(2),
  real_name varchar(32),
  qq varchar(14),
  email varchar(100),
  phone_number integer(13),
  tel varchar(255)
);

CREATE TABLE zk_cfg(
  id int(11) auto_increment  PRIMARY KEY,
  host varchar (32),
  name varchar (32),
  desc varchar (32)
);
