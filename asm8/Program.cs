using System;

class Program
{
    static void Main()
    {
        // Bài 1:
        PhanSo ps1 = new PhanSo(1, 2);
        PhanSo ps2 = new PhanSo(1, 3);

        Console.WriteLine($"ps1 = {ps1}");
        Console.WriteLine($"ps2 = {ps2}");
        Console.WriteLine();

        // Bài 2: Toán tử +, -, *, / giữa hai phân số
        Console.WriteLine($"ps1 + ps2 = {ps1 + ps2}");
        Console.WriteLine($"ps1 - ps2 = {ps1 - ps2}");
        Console.WriteLine($"ps1 * ps2 = {ps1 * ps2}");
        Console.WriteLine($"ps1 / ps2 = {ps1 / ps2}");
        Console.WriteLine();

        // Bài 3: So sánh phân số và toán tử với số nguyên
        PhanSo ps3 = new PhanSo(2, 4); 
        PhanSo ps4 = new PhanSo(1, 3);

        Console.WriteLine($"ps1 == ps3: {ps1 == ps3}");
        Console.WriteLine($"ps1 != ps4: {ps1 != ps4}");
        Console.WriteLine($"ps4 < ps1: {ps4 < ps1}");
        Console.WriteLine($"ps1 > ps4: {ps1 > ps4}");
        Console.WriteLine();

        Console.WriteLine($"ps1 + 2 = {ps1 + 2}");
        Console.WriteLine($"2 + ps1 = {2 + ps1}");
        Console.WriteLine();

        try
        {
            var invalid = new PhanSo(1, 0);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Caught expected exception: {ex.Message}");
        }
    }
}
