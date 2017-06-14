create table minesweeper(id varchar2(20), map varchar2(40), select_level varchar2(30), clear_time number, reg_date date)

drop table minesweeper

select * from MINESWEEPER

select * from (select * from minesweeper order by clear_time) where rownum<=10

select * from (select * from minesweeper where map = 'rect' and select_level= 'beginner' order by clear_time) where rownum<=10

