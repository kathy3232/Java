insert into users (username, first_name, last_name, email, address) values
('baobao', 'JiaQi', 'Deng', 'kathyjqd@gmail.com', '9300 Corporate Blvd, Apt1517, Rockville, MD, 20850' ),
('rhang', 'Ryo', 'Hang', 'ryo.hang@training.ascendingdc.com', '998 Washington Ave, Fairfax, VA 22030'),
('gzhang', 'Gloria', 'Zhang', 'gloria.zhang@training.ascendingdc.com', '997 Washington Ave, Fairfax, VA 22030'),
('xhuang', 'Xingyue', 'Huang', 'xingyue.Hang@training.ascendingdc.com', '996 Washington Ave, Fairfax, VA 22030')
;
commit;
insert into items (price, item_name, item_brand, item_type, quantity_in_stock) values
(5000, 'CoCo', 'Chanel','handbag','8'),
(1800, 'Lockybb', 'LV','handbag','5'),
(8000, 'Box', 'Celine','handbag','10'),
(10001, 'Kelly', 'Hermes','handbag','2')
;
commit;

insert into orders (comment, order_quantity, user_id, item_id) values
('N/A', 1,1,4),
('N/A', 3,3,3),
('N/A', 3,1,2),
('N/A', 4,4,1)
;
commit;