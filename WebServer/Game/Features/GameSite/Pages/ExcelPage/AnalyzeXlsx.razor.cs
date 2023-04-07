using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Forms;
using OfficeOpenXml;
using Radzen;
using System.Data;

namespace Game.Features.GameSite.Pages.ExcelPage
{
    public partial class AnalyzeXlsx
    {
        [Inject]
        DialogService _DialogService { get; set; } = null!;

        private async Task LoadTableFile(InputFileChangeEventArgs e)
        {
            var singleFile = e.File;

            if (singleFile.Name.IndexOf(".xlsx") > 0)
            {
                try
                {
                    MemoryStream ms = new MemoryStream();
                    var stream = singleFile.OpenReadStream(singleFile.Size);
                    await stream.CopyToAsync(ms);

                    ExcelPackage package = new ExcelPackage(ms);

                    var worksheet = package.Workbook.Worksheets[0];
                    object[,] value = (object[,])worksheet.Cells.Value;

                    int rowCount = worksheet.Dimension.Rows;
                    int colCount = worksheet.Dimension.Columns;

                    Dictionary<string, List<int>> tmDict = new();

                    for(int row = 1; row < rowCount; row++)
                    {
                        bool isEmpty = string.IsNullOrEmpty(value[row, 0]?.ToString());

                        if (true == isEmpty)
                            break;
 
                        if (value[row,1] is not null && string.IsNullOrEmpty(value[row,1].ToString()) == false)
                        {
                            if (tmDict.ContainsKey(value[row, 0].ToString()!) == false)
                                tmDict.Add(value[row, 0].ToString()!, new List<int>());
                             tmDict[value[row, 0].ToString()!].Add(Convert.ToInt32(value[row, 1]));
                        }
                        else
                        {
                            if (tmDict.ContainsKey(value[row, 0].ToString()!) == false)
                                tmDict.Add(value[row, 0].ToString()!, new List<int>());
                            tmDict[value[row, 0].ToString()!].Add(Convert.ToInt32(value[row, 2]));
                        }
                    }

                    Console.WriteLine();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
            else
            {
                await ShowMessage("웹 페이지 메세지", "xlsx 파일이 요구됩니다.");
            }
        }

        async Task ShowMessage(string title, string message)
        {
            await _DialogService.OpenAsync(title, ds => builder =>
            {
                builder.AddMarkupContent(0, $"<p>{message}</p>");
            });
        }
    }
}
