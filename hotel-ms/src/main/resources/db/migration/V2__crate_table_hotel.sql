CREATE TABLE hotel(

  id UUID  DEFAULT uuid_generate_v4() primary key,
  name varchar(100),
   location varchar(100),
   information text
);