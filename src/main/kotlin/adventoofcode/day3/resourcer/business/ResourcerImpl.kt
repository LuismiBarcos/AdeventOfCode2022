package adventoofcode.day3.resourcer.business

import adventoofcode.day3.resourcer.contracts.Resourcer
import java.net.URI

class ResourcerImpl: Resourcer {

    override fun getResourceURI(path: String): URI =
        ResourcerImpl::class.java.getResource(path)!!.toURI()
}