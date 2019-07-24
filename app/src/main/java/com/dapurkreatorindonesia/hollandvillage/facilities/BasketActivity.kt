package com.dapurkreatorindonesia.hollandvillage.facilities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dapurkreatorindonesia.hollandvillage.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class BasketActivity : AppCompatActivity() {

    lateinit var basketRenderable: ModelRenderable
    lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_basket)

        setupModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.sceneform_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel(anchorNode)

        }
    }

    private fun createModel(anchorNode: AnchorNode) {

        val basket = TransformableNode(arFragment.transformationSystem)
        basket.setParent(anchorNode)
        basket.renderable = basketRenderable
        basket.select()
    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.lapbasket)
            .build()
            .thenAccept { modelRenderable -> basketRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@BasketActivity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }
    }
}