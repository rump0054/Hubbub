databaseChangeLog = {

	changeSet(author: "Erik (generated)", id: "1427207075695-1") {
		addColumn(tableName: "profile") {
			column(name: "twitter_id", type: "varchar(255)")
		}
	}
}