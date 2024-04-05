# LIMIT

select menu_code, menu_name, menu_price
from tbl_menu
order by menu_price desc;
-- offerr, ow count


select menu_code, menu_name, menu_price
from tbl_menu
order by menu_price desc
limit 2,5;

select menu_code, menu_name, menu_price
from tbl_menu
order by menu_price desc
limit 7;