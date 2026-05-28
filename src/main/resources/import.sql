INSERT INTO tb_frete (data_envio, valor, nave_frete, tempo_viagem) VALUES (DATE '2026-05-10', 15000.00, 'Orion Cargo', 12);

INSERT INTO tb_frete (data_envio, valor, nave_frete, tempo_viagem) VALUES (DATE '2026-06-01', 22000.00, 'Galaxy Transport', 18);

INSERT INTO tb_frete (data_envio, valor, nave_frete, tempo_viagem) VALUES (DATE '2026-06-15', 9800.00, 'Star Delivery', 7);

INSERT INTO tb_frete (data_envio, valor, nave_frete, tempo_viagem) VALUES (DATE '2026-07-02', 30500.00, 'Nebula Express', 25);

-- INSERTS PARA tb_item
INSERT INTO tb_item (nome, peso, volume, data_validade, frete_id) VALUES ('Alimentos Desidratados', 120.5, 2.3, DATE '2027-01-10', 1);

INSERT INTO tb_item (nome, peso, volume, data_validade, frete_id) VALUES ('Oxigênio Líquido', 300.0, 5.7, DATE '2026-12-01', 2);

INSERT INTO tb_item (nome, peso, volume, data_validade, frete_id) VALUES ('Equipamento Médico', 45.8, 1.2, DATE '2028-03-15', 3);

INSERT INTO tb_item (nome, peso, volume, data_validade, frete_id) VALUES ('Painel Solar Compacto', 89.9, 3.1, DATE '2030-08-20', 4);