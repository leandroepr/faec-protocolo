CREATE TABLE classes (
 classId CHAR(10) NOT NULL,
 name CHAR(10),
 startAt CHAR(10),
 endAt CHAR(10),
 createdAt CHAR(10),
 UpdatedAt CHAR(10)
);

ALTER TABLE classes ADD CONSTRAINT PK_classes PRIMARY KEY (classId);


CREATE TABLE courses (
 courseId CHAR(10) NOT NULL,
 name CHAR(10),
 description CHAR(10),
 createdAt CHAR(10),
 updateAt CHAR(10)
);

ALTER TABLE courses ADD CONSTRAINT PK_courses PRIMARY KEY (courseId);


CREATE TABLE courses_modules (
 courseModuleId CHAR(10) NOT NULL,
 courseId CHAR(10) NOT NULL,
 description CHAR(10),
 name CHAR(10),
 initialDate CHAR(10),
 createdAt CHAR(10),
 updatedAt CHAR(10)
);

ALTER TABLE courses_modules ADD CONSTRAINT PK_courses_modules PRIMARY KEY (courseModuleId);


CREATE TABLE files_types (
 idFileType CHAR(10) NOT NULL,
 name CHAR(10),
 description CHAR(10),
 createdAt CHAR(10),
 updatedAt CHAR(10)
);

ALTER TABLE files_types ADD CONSTRAINT PK_files_types PRIMARY KEY (idFileType);


CREATE TABLE modules (
 moduleId NUMERIC(10) NOT NULL,
 name VARCHAR(50),
 displayName VARCHAR(50),
 createdAt TIMESTAMP(10),
 updatedAt TIMESTAMP
);

ALTER TABLE modules ADD CONSTRAINT PK_modules PRIMARY KEY (moduleId);


CREATE TABLE profiles (
 profileId NUMERIC(10) NOT NULL,
 name VARCHAR(200),
 description VARCHAR(10),
 createdAt TIMESTAMP
);

ALTER TABLE profiles ADD CONSTRAINT PK_profiles PRIMARY KEY (profileId);


CREATE TABLE request_action_type (
 requestActionTypeId CHAR(10) NOT NULL,
 name CHAR(10),
 description CHAR(10),
 createdAt CHAR(10),
 updatedAt CHAR(10)
);

ALTER TABLE request_action_type ADD CONSTRAINT PK_request_action_type PRIMARY KEY (requestActionTypeId);


CREATE TABLE request_reasons (
 requestReasonId CHAR(10) NOT NULL,
 name CHAR(10) NOT NULL,
 description CHAR(10),
 createdAt CHAR(10),
 updatedAt CHAR(10)
);

ALTER TABLE request_reasons ADD CONSTRAINT PK_request_reasons PRIMARY KEY (requestReasonId);


CREATE TABLE users (
 userId NUMERIC(10) NOT NULL,
 profileId NUMERIC(10) NOT NULL,
 username VARCHAR(50),
 password VARCHAR(50) NOT NULL,
 createdAt TIMESTAMP(10),
 updatedAt TIMESTAMP(10),
 active BIT(1)
);

ALTER TABLE users ADD CONSTRAINT PK_users PRIMARY KEY (userId);


CREATE TABLE classes_modules (
 classModuleId CHAR(10) NOT NULL,
 classId CHAR(10) NOT NULL,
 courseModuleId CHAR(10) NOT NULL,
 concluded CHAR(10)
);

ALTER TABLE classes_modules ADD CONSTRAINT PK_classes_modules PRIMARY KEY (classModuleId);


CREATE TABLE logs (
 logId CHAR(10) NOT NULL,
 userId NUMERIC(10) NOT NULL,
 action VARCHAR(200),
 screen CHAR(200),
 result CHAR(200),
 createdAt TIMESTAMP
);

ALTER TABLE logs ADD CONSTRAINT PK_logs PRIMARY KEY (logId);


CREATE TABLE menus (
 meuId NUMERIC(10) NOT NULL,
 moduleId NUMERIC(10) NOT NULL,
 name VARCHAR(50),
 displayName VARCHAR(50),
 icon VARCHAR(10),
 createdAt TIMESTAMP
);

ALTER TABLE menus ADD CONSTRAINT PK_menus PRIMARY KEY (meuId);


CREATE TABLE people (
 personId NUMERIC(10) NOT NULL,
 name CHAR(10),
 document CHAR(10),
 phoneNumber CHAR(10),
 email CHAR(10),
 pictureUrl CHAR(10),
 createdAt CHAR(10),
 updatedAt CHAR(10)
);

ALTER TABLE people ADD CONSTRAINT PK_people PRIMARY KEY (personId);


CREATE TABLE permissions (
 permisionId NUMERIC(10) NOT NULL,
 profileId NUMERIC(10) NOT NULL,
 menuId NUMERIC(10) NOT NULL,
 createdAt TIMESTAMP
);

ALTER TABLE permissions ADD CONSTRAINT PK_permissions PRIMARY KEY (permisionId);


CREATE TABLE students (
 studentId NUMERIC(10) NOT NULL,
 classId CHAR(10) NOT NULL,
 registration CHAR(10)
);

ALTER TABLE students ADD CONSTRAINT PK_students PRIMARY KEY (studentId);


CREATE TABLE employees (
 employeeId NUMERIC(10) NOT NULL,
 contractNumber CHAR(10),
 role CHAR(10)
);

ALTER TABLE employees ADD CONSTRAINT PK_employees PRIMARY KEY (employeeId);


CREATE TABLE requests (
 requestId CHAR(10) NOT NULL,
 creatorId NUMERIC(10) NOT NULL,
 requesterId NUMERIC(10) NOT NULL,
 status CHAR(10),
 otherReason CHAR(10),
 createdAt CHAR(10) NOT NULL,
 updatedAt CHAR(10)
);

ALTER TABLE requests ADD CONSTRAINT PK_requests PRIMARY KEY (requestId);


CREATE TABLE selected_reasons (
 selectedResonId CHAR(10) NOT NULL,
 requestId CHAR(10) NOT NULL,
 requestReasonId CHAR(10) NOT NULL
);

ALTER TABLE selected_reasons ADD CONSTRAINT PK_selected_reasons PRIMARY KEY (selectedResonId);


CREATE TABLE files (
 fileId CHAR(10) NOT NULL,
 requestId CHAR(10) NOT NULL,
 idFileType CHAR(10) NOT NULL,
 name CHAR(10),
 path CHAR(10),
 type CHAR(10),
 createdAt CHAR(10)
);

ALTER TABLE files ADD CONSTRAINT PK_files PRIMARY KEY (fileId);


CREATE TABLE request_histories (
 requestHistoryId CHAR(10) NOT NULL,
 personId NUMERIC(10) NOT NULL,
 requestId CHAR(10) NOT NULL,
 requestActionType CHAR(10) NOT NULL,
 createdAt CHAR(10),
 data CHAR(10)
);

ALTER TABLE request_histories ADD CONSTRAINT PK_request_histories PRIMARY KEY (requestHistoryId);


ALTER TABLE courses_modules ADD CONSTRAINT FK_courses_modules_0 FOREIGN KEY (courseId) REFERENCES courses (courseId);


ALTER TABLE users ADD CONSTRAINT FK_users_0 FOREIGN KEY (profileId) REFERENCES profiles (profileId);


ALTER TABLE classes_modules ADD CONSTRAINT FK_classes_modules_0 FOREIGN KEY (classId) REFERENCES classes (classId);
ALTER TABLE classes_modules ADD CONSTRAINT FK_classes_modules_1 FOREIGN KEY (courseModuleId) REFERENCES courses_modules (courseModuleId);


ALTER TABLE logs ADD CONSTRAINT FK_logs_0 FOREIGN KEY (userId) REFERENCES users (userId);


ALTER TABLE menus ADD CONSTRAINT FK_menus_0 FOREIGN KEY (moduleId) REFERENCES modules (moduleId);


ALTER TABLE people ADD CONSTRAINT FK_people_0 FOREIGN KEY (personId) REFERENCES users (userId);


ALTER TABLE permissions ADD CONSTRAINT FK_permissions_0 FOREIGN KEY (profileId) REFERENCES profiles (profileId);
ALTER TABLE permissions ADD CONSTRAINT FK_permissions_1 FOREIGN KEY (menuId) REFERENCES menus (meuId);


ALTER TABLE students ADD CONSTRAINT FK_students_0 FOREIGN KEY (studentId) REFERENCES people (personId);
ALTER TABLE students ADD CONSTRAINT FK_students_1 FOREIGN KEY (classId) REFERENCES classes (classId);


ALTER TABLE employees ADD CONSTRAINT FK_employees_0 FOREIGN KEY (employeeId) REFERENCES people (personId);


ALTER TABLE requests ADD CONSTRAINT FK_requests_0 FOREIGN KEY (creatorId) REFERENCES people (personId);
ALTER TABLE requests ADD CONSTRAINT FK_requests_1 FOREIGN KEY (requesterId) REFERENCES students (studentId);


ALTER TABLE selected_reasons ADD CONSTRAINT FK_selected_reasons_0 FOREIGN KEY (requestId) REFERENCES requests (requestId);
ALTER TABLE selected_reasons ADD CONSTRAINT FK_selected_reasons_1 FOREIGN KEY (requestReasonId) REFERENCES request_reasons (requestReasonId);


ALTER TABLE files ADD CONSTRAINT FK_files_0 FOREIGN KEY (requestId) REFERENCES requests (requestId);
ALTER TABLE files ADD CONSTRAINT FK_files_1 FOREIGN KEY (idFileType) REFERENCES files_types (idFileType);


ALTER TABLE request_histories ADD CONSTRAINT FK_request_histories_0 FOREIGN KEY (personId) REFERENCES people (personId);
ALTER TABLE request_histories ADD CONSTRAINT FK_request_histories_1 FOREIGN KEY (requestId) REFERENCES requests (requestId);
ALTER TABLE request_histories ADD CONSTRAINT FK_request_histories_2 FOREIGN KEY (requestActionType) REFERENCES request_action_type (requestActionTypeId);


