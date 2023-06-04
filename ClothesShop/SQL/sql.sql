use ClothesManagement




--delete from Category where name ='Sport Fashion'
--DBCC CHECKIDENT ('Product', RESEED, 8)



--INSERT INTO Authorizations (username,password,role,dateCreate) values (?,?,?,GETDATE())

--INSERT INTO Users(username,name,phone,address,status) values (?,?,?,?,?)
--insert into Category (name, dateCreate) values ('Sport Fashion', GETDATE())
--update product set isactive=1 where id=1
select top 4 * from   product order by sold desc
SELECT TOP 4 * FROM Product ORDER BY sold DESC



--update product set sold=7 where id=31

select * from Product
select * from Category

SELECT TOP 4 * FROM Product ORDER BY dateCreate asc
SELECT * FROM product AS p join Category AS c ON p.idCategory=c.id WHERE p.name LIKE '%buttons%' OR c.name LIKE '%wo%'

SELECT * FROM PRODUCT WHERE idCategory=1
SELECT * FROM Product WHERE  price >400

SELECT  a.username, u.name, u.phone, u.address, u.status FROM Authorizations AS a JOIN Users AS u ON a.username = u.username
--UPDATE Users SET status=1 WHERE username='messi'

SELECT a.username, a.password, a.role, u.name, u.phone, u.address, u.status FROM Authorizations AS a INNER  JOIN Users AS u ON a.username=u.username WHERE u.name LIKE '%nguyen%' 

--UPDATE Users SET name=?, phone=?, address=? WHERE username=?



--UPDATE Product SET quantity =? WHERE id=?
--INSERT INTO [Orders](username, totalMoney,dateCreate) VALUES('nguyen',150.0,GETDATE())
--INSERT INTO OrderDetail(orderId,productId,quantity,price,tax,shipping) VALUES(,?,?,?,?,?)

SELECT a.username, a.password, a.role, e.name, e.phone, e.address, e.status FROM Authorizations AS a INNER JOIN Employee AS e ON a.username=e.username WHERE a.username='admin' and a.password='1'

--insert into Employee(username) values('admin')
SELECT * FROM [Orders] WHERE status=0 
--update Employee set name='Van Dai' where username='admin'

SELECT * FROM [Orders] WHERE id= OR username LIKE ?

--update Orders set status =0 where id=7

--UPDATE [Orders] set status=1 WHERE id=7

--INSERT INTO OrderDetail(orderId,productId,quantity,price,tax,shipping,phone,address,name,email) VALUES(?,?,?,?,?,?,?,?,?,?)
SELECT * FROM OrderDetail WHERE orderId=7
--update OrderDetail set phone='0386472240', address='Thu Duc city',name='Ro nan do', email='vuchatnguyn@gmail.com' where orderId=7

SELECT p.sold FROM Product AS p WHERE id=7

--INSERT INTO [Orders](username, totalMoney,dateCreate,status) VALUES('demoo',430.00,GETDATE(),0)

SELECT p.sold FROM Product AS p WHERE id=7


SELECT p.sold FROM Product AS p WHERE id=7
--delete product where id=32

SELECT * FROM product AS p WHERE p.name LIKE '%o%'
--update product set isActive=1 where id=5
UPDATE Product SET name=?, idCategory=?,quantity=?,price=?,description=?,img=?,isActive=?, lastupdate=GETDATE() WHERE id=?

select * from Category
select * from Product where id=6
select * from Authorizations 
select * from users
select * from Orders
select * from OrderDetail
select * from Employee



delete Authorizations where username='###!@#'
SELECT a.username, password, role, name, status FROM Authorizations AS a INNER  JOIN Employee AS e ON a.username=e.username
UPDATE Employee SET name=? WHERE username=?

select * 
