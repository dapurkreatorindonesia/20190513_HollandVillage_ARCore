package com.dapurkreatorindonesia.hollandvillage.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dapurkreatorindonesia.hollandvillage.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class C12Activity : AppCompatActivity(){

    /*lateinit var arrayView : Array<View>

    lateinit var c12TampakDalamRenderable: ModelRenderable
    lateinit var c12TampakAtasRenderable: ModelRenderable
    lateinit var c12TampakLuarRenderable: ModelRenderable
    lateinit var arFragment: ArFragment

    internal var selected = 1

    override fun onClick(view: View?) {
        if (view!!.id == R.id.c12TD){
            selected = 1
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.c12TA){
            selected = 2
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.c12TL) {
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
        setContentView(R.layout.fragment_c12)

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

*//*
        val b3TD = TransformableNode(arFragment.transformationSystem)
            b3TD.setParent(anchorNode)
            b3TD.renderable = b3TampakDalamRenderable
            b3TD.select()
*//*

        if (selected == 1){
            val c12TD = TransformableNode(arFragment.transformationSystem)
            c12TD.setParent(anchorNode)
            c12TD.renderable = c12TampakDalamRenderable
            c12TD.select()
        }
        if (selected == 2){
            val c12TA = TransformableNode(arFragment.transformationSystem)
            c12TA.setParent(anchorNode)
            c12TA.renderable = c12TampakAtasRenderable
            c12TA.select()
        }
        if (selected == 3){
            val c12TL = TransformableNode(arFragment.transformationSystem)
            c12TL.setParent(anchorNode)
            c12TL.renderable = c12TampakLuarRenderable
            c12TL.select()
        }
    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.c12)
            .build()
            .thenAccept { modelRenderable -> c12TampakDalamRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@C12Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.c12)
            .build()
            .thenAccept { modelRenderable -> c12TampakAtasRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@C12Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.c12)
            .build()
            .thenAccept { modelRenderable -> c12TampakLuarRenderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@C12Activity,"Unable to load", Toast.LENGTH_SHORT).show()
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
            c12TD,
            c12TA,
            c12TL
        )
    }*/

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
            .setSource(this, R.raw.tipec12)
            .build()
            .thenAccept { modelRenderable -> c12Renderable = modelRenderable}
            .exceptionally { throwable -> Toast.makeText(this@C12Activity,"Unable to load", Toast.LENGTH_SHORT).show()
                null
            }
    }
}