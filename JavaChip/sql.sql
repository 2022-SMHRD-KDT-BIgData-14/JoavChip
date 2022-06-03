select * from J_user;

delete from j_RANKING where id='user1';
delete from j_RANKING where id='user2';
delete from j_RANKING where id='user3';
delete from j_RANKING where point=307;
delete from j_RANKING where id='¹é¼º¿¬';
delete from j_RANKING where point=15;

commit;
insert into j_user values('asdf', 'asdf', 'asdf', 1);

desc J_RANKING;

select rownum, id, point, lv from (select id, point, lv from J_RANKING order by point desc) where rownum<7;