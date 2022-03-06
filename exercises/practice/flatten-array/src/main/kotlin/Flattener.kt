object Flattener {

    fun flatten(source: Collection<Any?>): List<Any> {

       /* return source.filterNotNull().flatMap({element->
            if(element is Collection<Any?>){
                flatten(element)
            }
            else {
                listOf(element)
            }

        })*/


    //Alternative solution
    return source.filterNotNull().flatMap { it -> if (it is Int) listOf(it) else flatten(it as List<Any?>) }
    }
}
