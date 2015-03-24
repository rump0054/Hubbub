databaseChangeLog = {

	changeSet(author: "Erik (generated)", id: "1427217855720-1") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-2") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-3") {
		addColumn(tableName: "user") {
			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-4") {
		addColumn(tableName: "user") {
			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-5") {
		addColumn(tableName: "user") {
			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-6") {
		addColumn(tableName: "user") {
			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-7") {
		addColumn(tableName: "user") {
			column(name: "password_hash", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-8") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-11") {
		createIndex(indexName: "authority_uniq_1427217855471", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-12") {
		dropColumn(columnName: "PASSWORD", tableName: "USER")
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-9") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A8E0F37C6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427217855720-10") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
