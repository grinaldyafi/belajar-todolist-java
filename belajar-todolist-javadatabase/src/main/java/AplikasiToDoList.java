public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     *  Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if( todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0]="test todo 1";
        model[1]="test todo 2";
        showTodoList();
    }

    public static void addTodoList(String todo){
        // cek apakah model penuh?
        var isFull = true;
        for(var i =0; i< model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh, resize ukuran array 2x lipat
        // biasanya dibuat langsung 2x ukuran model
        // model = new String[model.length*2];
        // tapi nanti takutnya isi konten todolist ikut terhapus maka

        if(isFull){
            var temp = model;
            model = new String[model.length*2];

            for(var i=0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }


        // tambahkan ke posisi yang data arraynya NULL
        for(var i=0; i < model.length; i++){
            if(model[i] == null){
                model[i]= todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for(int i = 0; i < 25; i++){
            addTodoList("Todo ke " + i);
        }
        showTodoList();
    }

    public static boolean removeTodoList(Integer number){
        if ((number-1) >= model.length){
            return false;
        } else if(model[number-1] == null){
            return false;
        }else{
           for (int i = (number-1); i < model.length; i++){
               if(i == (model.length-1)){
                   model[i]= null;
               }else{
                   model[i]=model[i+1];
               }
           }
            return true;
        }
    }
    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : " );
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi, "+ name);
    }

    public static void viewShowTodoList() {
    while(true){
        showTodoList();

        System.out.println("MENU : ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = input("Pilih ");
        if(input.equals("1")){
            viewAddTodoList();
        }else if (input.equals("2")){
            viewRemoveTodoList();
        }else if (input.equals("x")){
            break;
        }else{
            System.out.println("Pilihan tidak dimengerti");
        }
     }
    }

     public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
         addTodoList("Empat");
         addTodoList("Lima");
        viewShowTodoList();
     }
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo ( x jika batal )");
        if(todo.equals("x")){
           viewShowTodoList();
        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        viewAddTodoList();
        viewShowTodoList();
    }
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Nomor yang dihapus (x jika batal)");
        if(number.equals("x")){
            //batal
        }else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("lalasl");
        addTodoList("lalasl");
        addTodoList("lalasl");
        addTodoList("lalasl");
        viewAddTodoList();
        viewShowTodoList();
        viewRemoveTodoList();
    }


}
