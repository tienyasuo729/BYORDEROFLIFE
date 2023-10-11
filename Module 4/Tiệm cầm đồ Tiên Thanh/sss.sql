create database dbi;
use dbi;

create table territory(
	territory_id int primary key,
    territory_name text
);

create table salesperson(
	salesperson_id int primary key,
    salesperson_name text,
    salesperson_telephone text,
    salesperson_fax text,
    territory_id int,
    foreign key (territory_id) references territory(territory_id)
);

create table customer(
	customer_id int primary key,
    customer_name text,
    customer_address text,
    customer_postal_code text
);

create table product_line(
	product_line_id int primary key,
    product_line_name text
);

create table product(
	product_id int primary key,
    product_description text,
    product_finish text,
    product_standard_price text,
    product_line_id int,
    foreign key (product_line_id) references product_line(product_line_id)
);

create table order_(
	order_id int primary key,
	customer_id int,
    order_date datetime,
    foreign key (customer_id) references customer(customer_id)
);

create table vendor(
	vendor_id int primary key,
    vendor_name text,
    vendor_address text
);

create table raw_material(
	material_id int primary key,
    material_name text,
    material_standard_cost text,
    unit_of_measure text
);

create table work_center(
	work_center_id int primary key,
    work_center_loaction text
);

create table employee(
	employee_id int primary key,
    employee_name text,
    employee_address text,
    supervissed INT,
    FOREIGN KEY (supervissed) REFERENCES Employee(employee_id)
);

create table skill(
	skill_id int primary key
);

create table skills(
	skills_id int primary key,
    skill_id int,
    skill_name text,
	skill_decriptions text,
	FOREIGN KEY (skill_id) REFERENCES skill(skill_id)salesperson
);

create table dose_business_in(
	dose_business_in_id int primary key,
    territory_id int,
    customer_id int,
    foreign key (territory_id) references territory(territory_id),
    foreign key (customer_id) references customer(customer_id)
);

create table order_line(
	order_line_id int primary key,
    order_id int,
    product_id int,
    ordered_quantity int,
    foreign key (order_id) references order_(order_id),
    foreign key (product_id) references product(product_id)
);

create table use_(
	use_id int primary key,
    material_id int,
    product_id int,
    use_into_quantity int,
    foreign key (material_id) references raw_material(material_id),
    foreign key (product_id) references product(product_id)
);

create table supplies(
	use_id int primary key,
    material_id int,
    vendor_id int,
    supply_unit_price int,
    foreign key (material_id) references raw_material(material_id),
    foreign key (vendor_id) references vendor(vendor_id)
);

create table produced_in(
	produced_in_id int primary key,
    work_center_id int,
    product_id int,
    foreign key (work_center_id) references work_center(work_center_id),
    foreign key (product_id) references product(product_id)
);

create table works_in(
	works_in_id int primary key,
    work_center_id int,
    employee_id int,
    foreign key (work_center_id) references work_center(work_center_id),
    foreign key (employee_id) references employee(employee_id)
);

create table has_skill(
	has_skill_id int primary key,
    skill_id int,
    employee_id int,
    foreign key (skill_id) references skill(skill_id),
    foreign key (employee_id) references employee(employee_id)
);
