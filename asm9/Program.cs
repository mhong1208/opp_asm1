using System;

class Program
{
    static void Main()
    {
        // Bài 1: Vector2D
        Vector2D v1 = new Vector2D(3, 4);
        Vector2D v2 = new Vector2D(1, 2);

        Console.WriteLine($"v1 = {v1}");
        Console.WriteLine($"v2 = {v2}");
        Console.WriteLine($"v1 + v2 = {v1 + v2}");
        Console.WriteLine($"v1 - v2 = {v1 - v2}");
        Console.WriteLine($"v1 * 2 = {v1 * 2}");
        Console.WriteLine($"3 * v2 = {3 * v2}");
        Console.WriteLine($"-v1 = {-v1}");
        Console.WriteLine($"|v1| = {v1.DoDai:F4}");
        Console.WriteLine($"v1 * v2 = {v1 * v2:F2}");

        Vector2D v3 = (3.0, 4.0);
        Console.WriteLine($"v3 implicit tuple = {v3}");
        Console.WriteLine($"v1 == v3: {v1 == v3}");
        Console.WriteLine($"v1 != v2: {v1 != v2}");

        Console.WriteLine();

        // Bài 2: Money
        Money luong = new Money(15_000_000m, "VND");
        Money thuong = new Money(3_000_000m, "VND");
        Money lamThemGio = luong * 1.5m;

        Console.WriteLine($"Luong co ban:   {luong}");
        Console.WriteLine($"Thuong thang:   {thuong}");
        Console.WriteLine($"Luong lam them: {lamThemGio}");
        Console.WriteLine($"Tong thu nhap:  {luong + thuong}");
        Console.WriteLine($"Luong > Thuong: {luong > thuong}");

        try
        {
            Money usd = new Money(100m, "USD");
            Money tong = luong + usd;
        }
        catch (InvalidOperationException ex)
        {
            Console.WriteLine($"Loi: {ex.Message}");
        }

        var usd100 = new Money(100m, "USD");
        var converted = Money.QuyDoi(usd100, "VND", 25_500m);
        Console.WriteLine($"100 USD = {converted}");

        var bill = new Money(2_000_000m, "VND");
        Console.WriteLine($"Phan cua 1 nguoi khi chia 4: {bill / 4}");
    }
}
