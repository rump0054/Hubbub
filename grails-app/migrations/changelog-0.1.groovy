databaseChangeLog = {

	changeSet(author: "Erik (generated)", id: "1427206822951-1") {
		createTable(tableName: "post") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "postPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "content", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-2") {
		createTable(tableName: "post_tags") {
			column(name: "post_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "tag_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-3") {
		createTable(tableName: "profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "bio", type: "varchar(1000)")

			column(name: "country", type: "varchar(255)")

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "full_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "homepage", type: "varchar(255)")

			column(name: "jabber_address", type: "varchar(255)")

			column(name: "photo", type: "binary(2097152)")

			column(name: "skin", type: "varchar(9)")

			column(name: "timezone", type: "varchar(255)")

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-4") {
		createTable(tableName: "tag") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-5") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "login_id", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(8)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-6") {
		createTable(tableName: "user_user") {
			column(name: "user_following_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-7") {
		addPrimaryKey(columnNames: "post_id, tag_id", tableName: "post_tags")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-15") {
		createIndex(indexName: "user_id_uniq_1427206822902", tableName: "profile", unique: "true") {
			column(name: "user_id")
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-16") {
		createIndex(indexName: "login_id_uniq_1427206822907", tableName: "user", unique: "true") {
			column(name: "login_id")
		}
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-8") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "post", constraintName: "FK3498A03339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-9") {
		addForeignKeyConstraint(baseColumnNames: "post_id", baseTableName: "post_tags", constraintName: "FK7762B85824AB4F86", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "post", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-10") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "post_tags", constraintName: "FK7762B8583081882E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tag", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-11") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "profile", constraintName: "FKED8E89A93339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-12") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "tag", constraintName: "FK1BF9A3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-13") {
		addForeignKeyConstraint(baseColumnNames: "user_following_id", baseTableName: "user_user", constraintName: "FK143D5FBF8FFB7714", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "Erik (generated)", id: "1427206822951-14") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_user", constraintName: "FK143D5FBF3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
