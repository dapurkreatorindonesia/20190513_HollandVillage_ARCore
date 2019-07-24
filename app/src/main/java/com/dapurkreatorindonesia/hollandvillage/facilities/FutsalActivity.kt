package com.dapurkreatorindonesia.hollandvillage.facilities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dapurkreatorindonesia.hollandvillage.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class FutsalActivity : AppCompatActivity() {

    lateinit var futsalRenderable: ModelRenderable
    lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_futsal)

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

        val futsal = TransformableNode(arFragment.transformationSystem)
        futsal.setParent(anchorNode)
        futsal.renderable = futsalRenderable
        futsal.select()
    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.lapfutsal)
            .build()
            .thenAccept { modelRenderable -> futsalRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@FutsalActivity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }
    }
}