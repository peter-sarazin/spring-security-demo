insert into Role ( role_Id, rolename ) values ( 1, 'ROLE_USER' );
insert into Role ( role_Id, rolename ) values ( 2, 'ROLE_ADMIN' );

insert into User ( user_Id, userName, password, enabled, verified ) values ( 1, 'admin', 'admin', true, false );
insert into User ( user_Id, userName, password, enabled, verified ) values ( 2, 'user', 'user', true, false );

insert into USER_HAS_ROLE values ( 1, 1 );
insert into USER_HAS_ROLE values ( 1, 2 );
insert into USER_HAS_ROLE values ( 2, 1 );

