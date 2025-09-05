CREATE TABLE TechMarket.cliente (
    id_cliente SERIAL PRIMARY KEY,
    nome_completo TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    telefone TEXT,
    data_cadastro TIMESTAMPTZ NOT NULL DEFAULT now()
);
CREATE TABLE TechMarket.categoria (
    id_categoria SERIAL PRIMARY KEY,
    nome_categoria TEXT NOT NULL UNIQUE,
    descricao TEXT
);
CREATE TABLE TechMarket.produto (
    id_produto SERIAL PRIMARY KEY,
    id_categoria INT NOT NULL,
    nome_produto TEXT NOT NULL,
    descricao TEXT,
    preco NUMERIC(14,4) NOT NULL,
    estoque_disponivel INT NOT NULL,
    imagem_url TEXT,
    FOREIGN KEY (id_categoria) REFERENCES TechMarket.categoria(id_categoria)
);
CREATE TABLE TechMarket.endereco_entrega (
    id_endereco SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    logradouro TEXT NOT NULL,
    numero INT NOT NULL,
    complemento TEXT,
    bairro TEXT NOT NULL,
    cidade TEXT NOT NULL,
    estado TEXT NOT NULL,
    cep TEXT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES TechMarket.cliente(id_cliente)
);
CREATE TABLE TechMarket.pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_endereco INT,
    data_pedido TIMESTAMPTZ NOT NULL DEFAULT now(),
    valor_total NUMERIC(18,4) NOT NULL,
    status TEXT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES TechMarket.cliente(id_cliente),
    FOREIGN KEY (id_endereco) REFERENCES TechMarket.endereco_entrega(id_endereco)
);
CREATE TABLE TechMarket.item_pedido (
    id_item SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES TechMarket.pedido(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES TechMarket.produto(id_produto)
);
CREATE TABLE TechMarket.pagamento (
    id_pagamento SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    forma_pagamento TEXT NOT NULL,
    status TEXT NOT NULL,
    data_pagamento TIMESTAMPTZ NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES TechMarket.pedido(id_pedido)
);
