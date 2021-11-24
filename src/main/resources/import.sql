
# --Ingreso de DetalleServicio
insert into detalle_servicio(costo_servicio, descripcion, fecha_creacion, fecha_expiracion) values(50.00 ,"Descripcion1", "2021-09-08 17:51:04.78", "2022-09-08 17:51:04.78");
insert into detalle_servicio(costo_servicio, descripcion, fecha_creacion, fecha_expiracion) values(90.00 ,"Descripcion2", "2021-09-08 17:51:04.78", "2022-09-08 17:51:04.78");

#--Ingreso de Servicio
insert into servicio(estado_servicio, nombre_servicio, tiene_detalle) values(1 ,"Plan 3Mbs con Cable",1);
insert into servicio(estado_servicio, nombre_servicio, tiene_detalle) values(1 ,"Plan 6Mbs con Cable",2);

#--Ingreso de Usuarios
insert into usuario(contrasenia, nom_usuario, usuario_validado) values("1234","Juan2021",0);
insert into usuario(contrasenia, nom_usuario, usuario_validado) values("1234","Dayannas",1);
insert into usuario(contrasenia, nom_usuario, usuario_validado) values("1234","Mateo1122",0);
insert into usuario(contrasenia, nom_usuario, usuario_validado) values("1234","Maria412",1);

#--Ingreso de Empleados
insert into empleado(dni, ape_paterno, ape_materno, area, direccion, email, nombre, num_telefono, sexo, tiene_usuario) values("70445735","Perez","Quispe","Administrativa","Av. Bella Vista","ElYulius@gmail.com","Juan","983709108","M",1);
insert into empleado(dni, ape_paterno, ape_materno, area, direccion, email, nombre, num_telefono, sexo, tiene_usuario) values("70423151","Miranda","Gamarra","Tecnica","Av. Micaela","teo12@gmail.com","Mateo","983709123","M",3);
insert into empleado(dni, ape_paterno, ape_materno, area, direccion, email, nombre, num_telefono, sexo, tiene_usuario) values("70423151","Basquez","Demian","Administrativa","Av. Faucet","Angelaa2@gmail.com","Angela","983709253","F",null);

#--Ingreso de Clientes
insert into cliente(dni, ape_paterno, ape_materno, email, nombre, num_telefono, sexo, tienes_usuario) values("70445734","Aranda","Arellano","Dayanne@gmail.com","Maria Dayanna","983709100","F",2);
insert into cliente(dni, ape_paterno, ape_materno, email, nombre, num_telefono, sexo, tienes_usuario) values("70445734","Basquez","Lopez","maria151@gmail.com","Bianca Maria","983704215","F",4);


#--Ingreso de Ticket
insert into ticket(descripcion_ticket, estado_ticket, fec_creacion, cliente_solicito) values("Solicitud de fallo de conexion",0,"2021-09-08 17:51:04.78",1);
insert into ticket(descripcion_ticket, estado_ticket, fec_creacion, cliente_solicito) values("Solicitud de mantenimiento",1,"2021-09-08 23:51:04.78",2);
insert into ticket(descripcion_ticket, estado_ticket, fec_creacion, cliente_solicito) values("Solicitud de cancelacion de contrato",1,"2021-09-08 19:51:04.78",1);


#--Ingreso de Respuestas
insert into respuesta(contenido, empleado_respondio, ticket_respondio) values("Envio de tecnico a direccion en contrato",1,2);
insert into respuesta(contenido, empleado_respondio, ticket_respondio) values("Envio de formulario y solicitud de aproximacion para cancelacion de contrato",1,3);


#--Ingreso de Contrato
insert into contrato(descripcion,direccion,estado_contrato,corresponde_cliente,tiene_servicio) values("Contrato de plan de internet y television","Av. Los Rozales",1,1,1);
insert into contrato(descripcion,direccion,estado_contrato,corresponde_cliente,tiene_servicio) values("Contrato de plan de internet y television","Av. Bella Vista",1,2,2);


#--Ingreso de PagoContrato
insert into pago(estado_pago,fecha_limite_pago,fecha_pago,monto,mora,corresponde_contrato) values(1,"2021-11-15 17:51:04.78" , "2021-11-15 17:51:04.78" , 150.00, 15.00, 1);
insert into pago(estado_pago,fecha_limite_pago,fecha_pago,monto,mora,corresponde_contrato) values(0,"2021-11-15 17:51:04.78" , "2021-11-15 17:51:04.78" , 150.00, NULL, 1);
insert into pago(estado_pago,fecha_limite_pago,fecha_pago,monto,mora,corresponde_contrato) values(0,"2021-11-15 17:51:04.78" , "2021-11-15 17:51:04.78" , 150.00, NULL, 1);

#--Modelo de Consultas






