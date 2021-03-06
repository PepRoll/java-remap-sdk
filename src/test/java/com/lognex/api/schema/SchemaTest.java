package com.lognex.api.schema;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lognex.api.LognexApi;
import com.lognex.api.TestAsserts;
import com.lognex.api.TestRandomizers;
import com.lognex.api.entities.agents.CounterpartyEntity;
import com.lognex.api.entities.documents.CustomerOrderDocumentEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class SchemaTest implements TestAsserts, TestRandomizers {
    private static final Logger logger = LogManager.getLogger(SchemaTest.class);

    @Test
    public void testCounterpartySchema() throws Exception {
        //todo register new company
        LognexApi api = new LognexApi(
                System.getenv("API_HOST"),
                System.getenv("API_LOGIN"),
                System.getenv("API_PASSWORD")
        ).timeWithMilliseconds();
        Schema schema = SchemaMapper.readSchema("counterparty.json");
        SchemaValidator<CounterpartyEntity> schemaValidator = new SchemaValidator<>(
                schema,
                api,
                api.entity().counterparty().path(),
                CounterpartyEntity.class);
        schemaValidator.check();
    }
    @Test
    public void testCostomerOrderSchema() throws Exception {
        //todo register new company
        LognexApi api = new LognexApi(
                System.getenv("API_HOST"),
                System.getenv("API_LOGIN"),
                System.getenv("API_PASSWORD")
        ).timeWithMilliseconds();
        Schema schema = SchemaMapper.readSchema("customerorder.json");
        SchemaValidator<CustomerOrderDocumentEntity> schemaValidator = new SchemaValidator<>(
                schema,
                api,
                api.entity().customerorder().path(),
                CustomerOrderDocumentEntity.class);
        schemaValidator.check();
    }
}
