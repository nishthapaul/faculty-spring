CREATE TABLE IF NOT EXISTS employee_credentials (
    employee_credentials_id int AUTO_INCREMENT,
    employee_id int,
    first_name varchar(255) NOT NULL,
    PRIMARY KEY (employee_credentials_id)
);
CREATE TABLE IF NOT EXISTS departments (
    department_id int AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    capacity int NOT NULL,
    PRIMARY KEY (department_id)
);
CREATE TABLE IF NOT EXISTS employees (
    employee_id int AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255),
    title varchar(255),
    photograph_path varchar(255),
    department int,
    PRIMARY KEY (employee_id),
    email varchar(255) NOT NULL UNIQUE,
    FOREIGN KEY (department) REFERENCES departments(department_id)
);
CREATE TABLE IF NOT EXISTS courses(
    course_id int AUTO_INCREMENT,
    course_code varchar(255) UNIQUE NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(255),
    academic_year int NOT NULL,
    term int NOT NULL,
    credits int NOT NULL,
    capacity int NOT NULL,
    faculty_id int,
    PRIMARY KEY (course_id),
    FOREIGN KEY (faculty_id) REFERENCES employees(employee_id)
);
CREATE TABLE IF NOT EXISTS course_schedule (
    course_schedule_id int AUTO_INCREMENT,
    course_id int,
    start_time varchar(5),
    end_time varchar(5),
    class_day varchar(10),
    room int NOT NULL,
    building varchar(255),
    PRIMARY KEY (course_schedule_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);