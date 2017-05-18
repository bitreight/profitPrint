-- Fill Up User
INSERT INTO `User` (`ID`, `Email`, `Phone`) VALUES (1, 'meow@test.com', '228-16-66');
INSERT INTO `User` (`ID`, `Email`, `Phone`) VALUES (2, 'gav@test.com', '202-03-27');

-- Fill Up Customer
INSERT INTO `Customer` (`ID`, `FirstName`, `LastName`) VALUES (1, 'Alexander', 'Soloduha');

-- Fill Up Executor
INSERT INTO `Executor` (`ID`, `Title`, `Address`, `CloseTime`, `OpenTime`, `Latitude`, `Longtitude`, `WebSite`) VALUES (2, 'MEOW-PRINT', 'Pushkina Street, 25', '19:00:00', '10:00:00', -100, 100, 'meowgav.by');

-- Fill Up UserCredentials
INSERT INTO `UserCredentials` (`ID`, `Login`, `Password`, `Role`, `UserId`) VALUES (1, 'admin', 'admin', 'ROLE_ADMIN', NULL );
INSERT INTO `UserCredentials` (`ID`, `Login`, `Password`, `Role`, `UserId`) VALUES (2, 'customer', 'customer', 'ROLE_CUSTOMER', 1);
INSERT INTO `UserCredentials` (`ID`, `Login`, `Password`, `Role`, `UserId`) VALUES (3, 'executor', 'executor', 'ROLE_EXECUTOR', 2);

-- Fill Up RegisterKey
INSERT INTO `RegisterKey` (`ID`, `value`, `ExecutorId`) VALUES (1, '123-456-78', 2);
INSERT INTO `RegisterKey` (`ID`, `value`, `ExecutorId`) VALUES (2, '876-543-21', NULL ); -- free key

-- Fill Up ExecutorServiceItem
INSERT INTO `ExecutorServiceItem` (`ID`, `Description`, `HighPriorityCoefficient`, `LowPriorityCoefficient`, `Name`, `Price`, `ExecutorId`) VALUES (1, 'cool service', 2, 0.5, 'meow service', 100, 2);

