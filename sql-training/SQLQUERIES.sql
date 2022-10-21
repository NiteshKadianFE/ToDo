--           BIRTHDAY TODAY

SELECT * FROM "users"
WHERE DATE_PART('day',birthday) = DATE_PART('day',CURRENT_DATE)
    AND DATE_PART('month',birthday) = DATE_PART('month',CURRENT_DATE);
    
    
    
    
    -------------------------------------------------------------------------------------
    
    
--                  USER WITH FAILED TRANSACTION

select DISTINCT user_name from "users" inner join
"transactions" on "users".user_id = "transactions".user_id and status=false;





--------------------------------------------------------------------------------------------




--              USER WITH NO ORDERS


SELECT DISTINCT user_name FROM "users" FULL OUTER JOIN
"orders" ON "orders".user_id = "users".user_id WHERE "orders".user_id IS NULL;





-----------------------------------------------------------------------------------------




--               FAILED TRANSACTIONS OF A USER


select * from "transactions" where user_id=1 and status=false;






-----------------------------------------------------------------------------------------



--        SUPERHIT PRODUCT


select product_name from product where product_id =
(select product_id from "orders" group by product_id having count(product_id)=
(select max(mycount) from (select product_id, count(product_id)
			    as mycount from "orders" group by product_id) "subq1"));
	




--        FLOP PRODUCT
                                  
                                  

select product_name from product where product_id =
(select product_id from "orders" group by product_id having count(product_id)=
(select min(mycount) from (select product_id, count(product_id)
					as mycount from "orders" group by product_id)"subq2);
					
					
					
					
					
---------------------------------------------------------------------------------------




--       USER WITH MAX PAYMENT


select user_name from users where user_id = 
(select user_id from "transactions" group by user_id having sum(amount)=
(select max(tpayment) from 
(select sum(amount) as tpayment, user_id from transactions group by user_id) "subq1"));






--      USER WITH MIN PAYMENT
                                       


select user_name from users where user_id = 
(select user_id from "transactions" group by user_id having sum(amount)=
(select min(tpayment) from 
(select sum(amount) as tpayment, user_id from transactions group by user_id) "subq1"));









--------------------------------------------------------------------------------------



--                     HIGHLY REPEAT USER



select * from public.users where user_id =
(select user_id from "orders" group by user_id having count(user_id)=
(select max(mycount) from (select user_id, count(user_id)
					as mycount from "orders" group by user_id) "subq"));
			
			
			
			
			
			
---------------------------------------------------------------------------------------



--                      EXPIRED COUPONS


select * from coupon where expiry_date<current_date;








---------------------------------------------------------------------------------------



--                ITEM'S QUANTITY MORE THAN 4


select * from orders where quantity>4;









--------------------------------------------------------------------------------------



--       TOTAL DISCOUNT AVAILED BY A USER IN LAST 6 MONTHS


select sum(discount) from 
coupon inner join "orders" on coupon.coupon_id = "orders".coupon_id and user_id=1 and
coupon.expiry_date > "orders".order_date and "orders".order_date > current_date - interval '6 month';








--------------------------------------------------------------------------------------



--            HIGHEST SELLING CATEGORY IN LAST QUARTER


select category_id,category_name from category where category_id=

(select category_id from 

  product inner join "orders" on product.product_id =
"orders".product_id

     where order_date>current_date - interval '3 month' group by
category_id having count(category_id)=

        (select max(mycount) from     

                (select category_id,count(category_id) as mycount from 

                      product inner join "orders" on product.product_id
= "orders".product_id

                         where order_date>current_date - interval '3 month' group by
category_id) category));







                                
                                
 --                               LOWEST SELLING CATEGORY IN LAST QUARTER
                                
                                
select category_id,category_name from category where category_id=

(select category_id from 

  product inner join "orders" on product.product_id =
"orders".product_id

     where order_date>current_date - interval '3 month' group by
category_id having count(category_id)=

        (select min(mycount) from     

                (select category_id,count(category_id) as mycount from 

                      product inner join "orders" on product.product_id
= "orders".product_id

                         where order_date>current_date - interval '3 month' group by
category_id) category));

			
			


					
					
					
					
					

------------------------------------------------------------------------------------------------




