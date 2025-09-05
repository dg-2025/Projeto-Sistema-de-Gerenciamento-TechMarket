-- Remove todas as tabelas do schema TechMarket em ordem segura
DROP TABLE IF EXISTS TechMarket.pagamento CASCADE;
DROP TABLE IF EXISTS TechMarket.item_pedido CASCADE;
DROP TABLE IF EXISTS TechMarket.pedido CASCADE;
DROP TABLE IF EXISTS TechMarket.endereco_entrega CASCADE;
DROP TABLE IF EXISTS TechMarket.produto CASCADE;
DROP TABLE IF EXISTS TechMarket.categoria CASCADE;
DROP TABLE IF EXISTS TechMarket.cliente CASCADE;
