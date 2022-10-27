use agenciadeviagens;

insert into destino(destino_estado, destino_cidade, destino_ida, destino_volta) values ("Uva"," Laranja","67676", "57475");
select * from destino;

										
insert into cliente(cliente_nome,cliente_cpf,cliente_nascimento) values ("asasa","asasasasa", "asasasas");
select * from cliente;

select c.cliente_nome, c.cliente_cpf, c.cliente_nascimento, c.id, d.destino_estado, d.destino_cidade, d.destino_ida, d.destino_volta
from destino as d
inner join  cliente as  c
on c.id = d.id;
 

	
