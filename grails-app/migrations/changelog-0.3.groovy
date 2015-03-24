databaseChangeLog = {

	changeSet(author: "Erik (by hand)", id: "1427208105241-1") {
    dropColumn(columnName: "twitter_id", tableName: "profile")
  }
}