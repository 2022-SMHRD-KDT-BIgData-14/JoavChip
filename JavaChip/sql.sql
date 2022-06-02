insert into j_user values('asdf', 'asdf', 'asdf', 1);

desc J_RANKING;

select rownum, id, point, lv from (select id, point, lv from J_RANKING order by point desc) where rownum<7;