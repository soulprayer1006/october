insert into 'test'(id, name, password)
values (1, '测试', '123456');
# select id
# from test
select * from test;
select id from test;

drop table  if exists 'demo';
create table 'demo'(
    'id' bigint not null  comment 'id',
    'name' varchar(50) comment '名称',
    primary key ('id')
)engine =innobd default charset =utf8mb4
comment '测试';
insert into 'demo'(id, name) values (1,'测试')；




