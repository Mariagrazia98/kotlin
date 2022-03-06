object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val regex = Regex("[^A-Za-z0-9']")
        val list=phrase.toLowerCase().split("(\\s+|\t|,|\n)+".toRegex()).map({item->regex.replace(item, "")})
        //return list.filter({it!=""}).map({item->item.removeSurrounding("'")}).groupBy({it}).mapValues({it.value.size})

        /** Alternative solution */
        val list2=phrase.toLowerCase().split(regex).filter(String::isNotEmpty).map({item->item.removeSurrounding("'")}).groupBy({it}).mapValues({it.value.size})
        //return list2

        /** Alternative solution */
        val list3=phrase.toLowerCase().split(regex).filter(String::isNotEmpty).map({item->item.removeSurrounding("'")}).groupingBy{it}.eachCount()
        ///groupingBY can be used to group a collection by key and fold each group simultaneously. For example, it can be used to count the number of words starting with each letter
        return list3

        /** Alternative solution */
        var list4=phrase.split(Regex("[^\\w']+")).filter(String::isNotEmpty).map({item->item.removeSurrounding("'")}).groupingBy(String::toLowerCase).eachCount()
        return list4
    //The \w metacharacter matches word characters.
        //A word character is a character a-z, A-Z, 0-9, including _ (underscore).
    }
}
