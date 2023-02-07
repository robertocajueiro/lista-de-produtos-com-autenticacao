create table mentoria.tbl_usuario (
	id bigint not null auto_increment,
    login varchar(80) not null,
    senha varchar(80) not null, 
    
    primary key(id)
) engine=InnoDB default charset=utf8;