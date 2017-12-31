/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 6.0.0-alpha-community-nt-debug : Database - quiz
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quiz` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `quiz`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `name` varchar(50) DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `dob` varchar(15) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`name`,`userid`,`dob`,`mobile`,`email`,`address`,`password`) values 
('Ritvik','315','23/Sep/1998','9092030806','ritvik@gmail.com','315, Shanti \nNagar \nDurgapura','rit123');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `question` varchar(300) DEFAULT NULL,
  `optionA` varchar(100) DEFAULT NULL,
  `optionB` varchar(100) DEFAULT NULL,
  `optionC` varchar(100) DEFAULT NULL,
  `optionD` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `questions` */

insert  into `questions`(`question`,`optionA`,`optionB`,`optionC`,`optionD`,`answer`) values 
('Exception and Error are immediate subclasses\n of a class called ',' Object ','Throwable ','AWT ','Panel ','Throwable '),
('The order of the three top level elements of the\n java source file are ','Import, Package, Class','Class, Import, Package','Package, Import, Class','Random order','Package, Import, Class'),
('Java uses ___ to represent characters ','ASCII code ','Unicode ','Byte code ','None of the above ','Unicode '),
('Which one is not supported by OOP? ','Abstraction ','Polymorphism ','Encapsulation ','Global variables ','Global variables '),
('Java programs are ','Platform-dependent ','Interpreter-dependent ','Platform-independent ','Interpreter-independent ','Platform-independent '),
('The new operator ','returns a pointer to a variable ','creates a variable called new ','obtains memory for a new variable ','tells how much memory is available ','obtains memory for a new variable '),
('Java language has support for which of the\n following types of comment? ','block, line and javadoc ','javadoc, literal and string ','javadoc, char and string ','single, multiple and quote ','block, line and javadoc '),
('Command to execute a compiled java program is : ','javac ','java ','run ','execute ','java '),
(' ______ is a mechanism for naming and visibility\n control of a class and its content. ','Object ','Packages ','Interfaces ','None of the Mentioned ','Packages '),
(' What is the name of the method used to schedule\n a thread for execution? ','init() ','start() ','run() ','resume() ','run() ');

/*Table structure for table `questions2` */

DROP TABLE IF EXISTS `questions2`;

CREATE TABLE `questions2` (
  `question` varchar(300) DEFAULT NULL,
  `optionA` varchar(100) DEFAULT NULL,
  `optionB` varchar(100) DEFAULT NULL,
  `optionC` varchar(100) DEFAULT NULL,
  `optionD` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `questions2` */

insert  into `questions2`(`question`,`optionA`,`optionB`,`optionC`,`optionD`,`answer`) values 
('Which constructor creates an empty string buffer\n with the specified capacity as length. ',' StringBuffer()','StringBuffer(String str)','StringBuffer(int capacity)','None of the above','StringBuffer(int capacity)'),
('How many reserved keywords are currently defined\n in the Java language?','48','49','50','47','49'),
('Which mechanism is used when a thread is\n paused running in its critical section and another\n thread is allowed to enter (or lock) in the same \ncritical section to be executed? ','Inter-thread communication','Initial-thread communication','Mutual Exclusive','None of the above','Initial-thread communication'),
('Mutual exclusive and inter-thread communication \nare which type of Synchorization?','Thread Synchronization','Process Synchronization','Object Synchronization','None of the above','Thread Synchronization'),
('Which is irrecoverable? ','Error','Checked Exception','Unchecked Exception','Both B & C','Error'),
(' What is known as the classes that extend \nThrowable class except RuntimeException and \nError? ','Checked Exception','Unchecked Exception','Error','None of the above','Checked Exception'),
(' Which Exception occurs when a class is not found\n while dynamically loading a class using the class\n loaders?','ClassNotFoundException','ClassFoundException','NoClassDefFoundError','ClassDefFoundError','ClassNotFoundException'),
('Which is used to separate the hierarchy of the \nclass while declaring an import statement?','Package','Applet','Browser','All of the above','Package'),
('Which Thread pool is used where container \ncreates a thread pool to process the request?','Servlet','JSp','All of the above','None of the above','All of the above'),
('Which statement provides an easy way to dispatch\n execution to different parts of your code based on\n the value of an expression?','If','Switch','Nested-if','if-else-if','Switch'),
('Which provides accessibility to classes and\n interface?','import','Static import','All the above','None of the above','import');

/*Table structure for table `questions3` */

DROP TABLE IF EXISTS `questions3`;

CREATE TABLE `questions3` (
  `question` varchar(300) DEFAULT NULL,
  `optionA` varchar(100) DEFAULT NULL,
  `optionB` varchar(100) DEFAULT NULL,
  `optionC` varchar(100) DEFAULT NULL,
  `optionD` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `questions3` */

insert  into `questions3`(`question`,`optionA`,`optionB`,`optionC`,`optionD`,`answer`) values 
('What can be accessed or inherited without actual \ncopy of code to each program? ','Browser','Applet','Package','None of the above','Package'),
('Which variables are created when an object is \ncreated with the use of the keyword \'new\' and \ndestroyed when the object is destroyed?','Local variables','Instance variables','Class Variables','Static variables','Instance variables'),
('Which is a superclass of all exception classes?','Throwable','Exception','RuntimeException','IOException','Throwable'),
('Which access specifiers can be used for a class\n so that it?s members can be accessed by a\n different class in the different package? ','Private','Public','Protected','None of the above','Public'),
('Which keyword is used to make the classes and\n interface of another package accessible to the\n current package?','Import','Implements','Instanceof','None of the above','Import'),
(' Which method returns a reference to the currently\n executing thread object?','currentThread()','runningThread()','runnableThread()','None of the above','currentThread()'),
(' Which are subclasses of FilterInputStream and\n FilterOutputStream?','PipedInputStream','DataInputStream','DataOutputStream','Both B & C','Both B & C'),
('Which is a mechanism where one object acquires\n all the properties and behaviors of the parent \nobject?','Inheritance','Encapsulation','Polymorphism','None of the above','Inheritance'),
(' Which class is thread-safe i.e. multiple threads\n cannot access it simultaneously,So it is safe and \nwill result in an order?','StringBuffer class','StringBuilder class','Both A & B','None of the above','StringBuffer class'),
('Which method of object class can clone an object?','copy()','Objectcopy()','Objectclone()','Clone()','Objectclone()');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `name` varchar(50) DEFAULT NULL,
  `regno` varchar(20) DEFAULT NULL,
  `dob` varchar(15) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `quiz1` int(10) DEFAULT NULL,
  `quiz2` int(10) DEFAULT NULL,
  `quiz3` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`name`,`regno`,`dob`,`mobile`,`email`,`address`,`password`,`quiz1`,`quiz2`,`quiz3`) values 
('Ritvik Jain','315','1/Jan/2010','9092030806','ritvik@gmail.com','shanti nagar\n Durgapura','rit123',0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
