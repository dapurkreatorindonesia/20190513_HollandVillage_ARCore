package com.dapurkreatorindonesia.hollandvillage.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dapurkreatorindonesia.hollandvillage.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode


class B5Activity : AppCompatActivity(){

    lateinit var c12Renderable: ModelRenderable
    lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_c12)
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

        val c12 = TransformableNode(arFragment.transformationSystem)
        c12.setParent(anchorNode)
        c12.renderable = c12Renderable
        c12.select()
    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.tipeb5)
            .build()
            .thenAccept { modelRenderable -> c12Renderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@B5Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }
    }
}


/*

class B5Activity : AppCompatActivity(), View.OnClickListener {

    lateinit var arrayView : Array<View>

    lateinit var b5TampakDalamRenderable: ModelRenderable
    lateinit var b5TampakAtasRenderable: ModelRenderable
    lateinit var b5TampakLuarRenderable: ModelRenderable
    lateinit var arFragment: ArFragment

    internal var selected = 1

    override fun onClick(view: View?) {
        if (view!!.id == R.id.b5TD){
            selected = 1
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.b5TA){
            selected = 2
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.b5TL) {
            selected = 3
            mySetBackground(view!!.id)
        }
    }

    private fun mySetBackground(id: Int) {
        for (i in arrayView.indices){

            if (arrayView[i].id == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333869"))
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_b5)

        setupArray()
        setupClickListener()
        setupModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.sceneform_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel(anchorNode, selected)

        }
    }

    private fun createModel(anchorNode: AnchorNode, selected: Int) {

*/
/*
        val b3TD = TransformableNode(arFragment.transformationSystem)
            b3TD.setParent(anchorNode)
            b3TD.renderable = b3TampakDalamRenderable
            b3TD.select()
*//*


        if (selected == 1){
            val b5TD = TransformableNode(arFragment.transformationSystem)
            b5TD.setParent(anchorNode)
            b5TD.renderable = b5TampakDalamRenderable
            b5TD.select()
        }
        if (selected == 2){
            val b5TA = TransformableNode(arFragment.transformationSystem)
            b5TA.setParent(anchorNode)
            b5TA.renderable = b5TampakAtasRenderable
            b5TA.select()
        }
        if (selected == 3){
            val b5TL = TransformableNode(arFragment.transformationSystem)
            b5TL.setParent(anchorNode)
            b5TL.renderable = b5TampakLuarRenderable
            b5TL.select()
        }
    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.b5)
            .build()
            .thenAccept { modelRenderable -> b5TampakDalamRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@B5Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.b5)
            .build()
            .thenAccept { modelRenderable -> b5TampakAtasRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@B5Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.b5)
            .build()
            .thenAccept { modelRenderable -> b5TampakLuarRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@B5Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }
    }

    private fun setupClickListener() {
        for (i in arrayView.indices){
            arrayView[i].setOnClickListener(this)
        }
    }

    private fun setupArray() {
        arrayView = arrayOf(
            b5TD,
            b5TA,
            b5TL
        )
    }
}

*/
