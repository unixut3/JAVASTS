drop table GUEST;
create table GUEST(guest_no number(10) not null primary key,
		guest_name varchar2(20) not null,
		guest_date date not null,
		guest_email varchar2(50),
		guest_homepage varchar2(50),
		guest_title varchar2(100) not null,
		guest_content varchar2(4000) not null);

drop sequence guest_no_seq;
create sequence guest_no_seq  increment by 1 start with 1;

insert into GUEST values(guest_no_seq.nextval , '���ȣ', sysdate, 'guard@naver.com', 'http://', '���� ����', '����ó�� ����Ͻø� �˴ϴ�');


delete from guest where guest_no = 1;

update guest set guest_name='name����',
                 guest_email='email����',
                 guest_homepage='homepage����',
                 guest_title='title����',
                 guest_content='content����'
where guest_no = 3;

select * from guest;

select * from guest where guest_no = 3;

commit;

DESC guest;







