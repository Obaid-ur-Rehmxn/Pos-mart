
--
-- Database: `pos-mart`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_company`
--


CREATE TABLE tbl_company (
  company_id int NOT NULL Primary key identity(1,1),
  company_name varchar(1000) NOT NULL,
  company_shortname varchar(100) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_expense1`
--

CREATE TABLE tbl_expense1 (
  expense_id int NOT NULL primary key identity(1,1),
  expense_date date NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table `tbl_expense2`
--

CREATE TABLE tbl_expense2 (
  expense_serial int NOT NULL primary key identity(1,1),
  expense_description varchar(1000) DEFAULT NULL,
  expense_amount int DEFAULT NULL,
  expense_Fkid int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory`
--

CREATE TABLE tbl_inventory (
  inventory_id int NOT NULL primary key identity(1,1),
  inventory_Fkcompany int NOT NULL,
  inventory_code varchar(20) NOT NULL,
  inventory_name varchar(1000) NOT NULL,
  inventory_barcode int DEFAULT NULL,
  invemtory_description varchar(1000) DEFAULT NULL,
  inventory_imageurl varchar(1000) DEFAULT NULL,
  inventory_saleprice decimal(10,2) DEFAULT NULL,
  inventory_saledisc decimal(10,2) DEFAULT NULL,
  inventory_saletax decimal(10,2) DEFAULT NULL,
  inventory_purchaseprice decimal(10,2) DEFAULT NULL,
  inventory_purchasedisc decimal(10,2) DEFAULT NULL,
  inventory_purchasetax decimal(10,2) DEFAULT NULL,
  inventory_quantity int DEFAULT NULL,
  inventory_minstock int DEFAULT NULL,
  inventory_inactive tinyint NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purchase1`
--

CREATE TABLE tbl_purchase1 (
  purcahse_id int NOT NULL primary key identity(1,1),
  purchase_name varchar(1000) NOT NULL,
  purchase_date date NOT NULL,
  purchase_ttlamount int DEFAULT NULL,
  purchase_cashgiven int DEFAULT NULL
) 

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purchase2`
--

CREATE TABLE tbl_purchase2 (
  purchase_serialno int NOT NULL primary key identity(1,1),
  purchase_Fkid int NOT NULL,
  purchase_Fkproduct varchar(1000) NOT NULL,
  purchase_price int DEFAULT NULL,
  purchase_disc int DEFAULT NULL,
  purchase_tax int DEFAULT NULL,
  purchase_quantity int DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sales1`
--

CREATE TABLE tbl_sales1 (
  sales_id int NOT NULL primary key identity(1,1),
  sales_customer int NOT NULL,
  sales_data date NOT NULL,
  sales_ttlamount int DEFAULT NULL,
  sales_cashreceived int DEFAULT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sales2`
--

CREATE TABLE tbl_sales2 (
  sales_serialno int NOT NULL primary key identity(1,1),
  sales_Fkid int NOT NULL,
  sales_Fkproduct varchar(1000) NOT NULL,
  sales_price int NOT NULL,
  sales_disc int DEFAULT NULL,
  sales_tax int DEFAULT NULL,
  sales_quantity int NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE tbl_users (
  users_id int NOT NULL primary key identity(1,1),
  users_name varchar(1000) NOT NULL,
  users_password varchar(255) NOT NULL
)
Select * from tbl_users
Select * from tbl_company
Select * from tbl_inventory
Select * from tbl_expense1
Select * from tbl_expense2
Select * from tbl_sales1
Select * from tbl_sales2
Select * from tbl_purchase1
Select * from tbl_purchase2

ALTER TABLE tbl_purchase2 ADD FOREIGN KEY (purchase_Fkid) REFERENCES tbl_purchase1(purcahse_id) on DELETE No action on UPDATE CASCADE
ALTER TABLE tbl_inventory ADD FOREIGN KEY (inventory_Fkcompany) REFERENCES tbl_company(company_id) on DELETE No action on UPDATE CASCADE
ALTER TABLE tbl_sales2 ADD FOREIGN KEY (sales_Fkid) REFERENCES tbl_sales1(sales_id) on DELETE No action on UPDATE CASCADE
ALTER TABLE tbl_expense2 ADD FOREIGN KEY (expense_Fkid) REFERENCES tbl_expense1(expense_id) on DELETE No action on UPDATE CASCADE



