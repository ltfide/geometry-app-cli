package kawah.edukasi;

import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.repository.bangundatar.PersegiRepository;
import kawah.edukasi.repository.bangundatar.SegitigaRepository;
import kawah.edukasi.view.bangundatar.PersegiView;
import kawah.edukasi.view.bangundatar.SegitigaService;
import kawah.edukasi.util.InpuUtil;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Lutfi Dendiansyah
 * Kawah Edukasi
 */
public class App 
{
    public static void main( String[] args )
    {
        // segitiga
        SegitigaRepository segitigaRepository = new SegitigaRepository();
        SegitigaService segitigaService = new SegitigaService(segitigaRepository);

        // Persegi
        PersegiRepository persegiRepository = new PersegiRepository();
        PersegiView persegiView = new PersegiView(persegiRepository);

        while (true) {
            String input = InpuUtil.input().toLowerCase(Locale.ROOT);
            Pattern pattern = Pattern.compile("(luas|keliling|alas|tinggi|diagonal).*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            if (input.startsWith("segitiga")) {
                segitigaService.showSegitiga(matcher);
            } else if (input.startsWith("persegi")) {
                persegiView.showPersegi(matcher);
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }

            System.out.print("\n");
        }
    }

    public static void helpMenu() {
        System.out.println("Deskripsi:");
        System.out.println("Daftar Perintah \n");

        System.out.println("Cara Pengunaan:");
        System.out.println("list [options] \n");
    }
}
