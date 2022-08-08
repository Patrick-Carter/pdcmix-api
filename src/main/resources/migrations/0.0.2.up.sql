CREATE TABLE IF NOT EXISTS public.candles
(
    id uuid NOT NULL,
    market character varying(255) NOT NULL,
	time_period_start timestamp with time zone NOT NULL,
    time_period_end timestamp with time zone NOT NULL,
    time_open timestamp with time zone NOT NULL,
    time_close timestamp with time zone NOT NULL,
    price_open numeric(15,2) NOT NULL,
    price_close numeric(15,2) NOT NULL,
    price_high numeric(15,2) NOT NULL,
    price_low numeric(15,2) NOT NULL,
    volume_traded numeric(15,7) NOT NULL,
    trades_count integer NOT NULL,
    CONSTRAINT market_data_pkey PRIMARY KEY (id)
);

