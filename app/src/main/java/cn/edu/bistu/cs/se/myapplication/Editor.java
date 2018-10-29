package cn.edu.bistu.cs.se.myapplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Editor extends Activity  {

    private EditText ContentEditText=null;
    private EditText TitleEditText;
    private String noteId=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);
        Intent intent=getIntent();
        TitleEditText=(EditText)Editor.this.findViewById(R.id.noteEditTitle);
        ContentEditText=(EditText)Editor.this.findViewById(R.id.noteEditContent);
        TakeContent();

        //取消按钮
        Button btn_cancel=(Button)findViewById(R.id.noteButtonCancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editor.this.finish();;
            }
        });
        //保存按钮
        Button btn_save=(Button)findViewById(R.id.noteButtonSave);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = TitleEditText.getText().toString();
                final String contentEdit = ContentEditText.getText().toString();
                if ("".equals(title)||"".equals(contentEdit)) {
                    Toast.makeText(Editor.this, "标题和内容不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                //提示保存
                new AlertDialog.Builder(Editor.this).setTitle("保存提示框")
                        .setMessage("确定保存事件吗？").setPositiveButton("确认", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("title",title);
                        contentValues.put("content", contentEdit);
                        if ("".equals(noteId)) {
                           DBServer.addNotes(contentValues);
                        } else {
                           DBServer.updateNotesById(Integer.valueOf(noteId),contentValues);
                        }

                        Editor.this.finish();


                    }
                }).setNegativeButton("取消", null).show();

            }

        });

        }

        //根据ID取出内容的方法
        private void TakeContent(){
        long id=this.getIntent().getIntExtra("id",-1);
        if(id!=-1L){
            String noteId=String.valueOf(id);
            Cursor cursor=DBServer.selectNotesById((int)id);
            if(cursor.moveToFirst()){
                TitleEditText.setText(cursor.getString(1));
                ContentEditText.setText(cursor.getString(1));
            }
        }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



}
