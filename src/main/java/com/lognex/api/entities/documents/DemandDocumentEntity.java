package com.lognex.api.entities.documents;

import com.lognex.api.entities.*;
import com.lognex.api.entities.agents.AgentEntity;
import com.lognex.api.entities.agents.OrganizationEntity;
import com.lognex.api.responses.ListEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Отгрузка
 */

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DemandDocumentEntity extends DocumentEntity {
    private AgentEntity agent;
    private MetaEntity agentAccount;
    private List<AttributeEntity> attributes;
    private ContractEntity contract;
    private LocalDateTime created;
    private CustomerOrderDocumentEntity customerOrder;
    private LocalDateTime deleted;
    private String description;
    private ListEntity<DocumentEntity> documents;
    private String externalCode;
    private OrganizationEntity organization;
    private MetaEntity organizationAccount;
    private Overhead overhead;
    private Integer payedSum;
    private ListEntity positions;
    private MetaEntity project;
    private RateEntity rate;
    private StateEntity state;
    private StoreEntity store;
    private String syncId;
    private Boolean vatEnabled;
    private Boolean vatIncluded;
    private Integer vatSum;
}
