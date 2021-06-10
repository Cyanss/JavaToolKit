

DROP TABLE IF EXISTS "public"."zuul_white_list";
CREATE TABLE "public"."zuul_white_list"(
  "path" VARCHAR(64) COLLATE "default" NOT NULL,
  "status" INT4 DEFAULT 1,
  "create_time" TIMESTAMPTZ,
  "update_time" TIMESTAMPTZ,
  PRIMARY KEY ("path")
);
COMMENT ON COLUMN "public"."zuul_white_list"."path" IS '白名单路径';
COMMENT ON COLUMN "public"."zuul_white_list"."status" IS '白名单状态 1:新增，0：默认';
COMMENT ON COLUMN "public"."zuul_white_list"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."zuul_white_list"."update_time" IS '更新时间';

DROP TABLE IF EXISTS "public"."zuul_route_list";
CREATE TABLE "public"."zuul_route_list"(
  "path" VARCHAR(64) COLLATE "default" NOT NULL,
  "location" VARCHAR(128) COLLATE "default" NOT NULL,
  "name" VARCHAR(64) COLLATE "default",
  "status" INT4 DEFAULT 1,
  "create_time" TIMESTAMPTZ,
  "update_time" TIMESTAMPTZ,
  PRIMARY KEY ("path")
);
COMMENT ON COLUMN "public"."zuul_route_list"."path" IS '路由路径';
COMMENT ON COLUMN "public"."zuul_route_list"."location" IS '路由位置';
COMMENT ON COLUMN "public"."zuul_route_list"."name" IS '路由名称';
COMMENT ON COLUMN "public"."zuul_route_list"."status" IS '路由状态 1:新增，0：默认';
COMMENT ON COLUMN "public"."zuul_route_list"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."zuul_route_list"."update_time" IS '更新时间';

CREATE INDEX "IDX_ZUUL_ROUTE_LIST_NAME" ON "public"."zuul_route_list" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops"
);
