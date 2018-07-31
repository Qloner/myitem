$(function()
{
	
	$("#btnall").click(function()
	{// 全选
		var aa = $(":checkbox[name='cm']");
		for (i = 0; i < aa.length; i++)
		{
			aa[i].checked = true;// 把对应项的checked属性设置为true
		}
	});

	$("#btnno").click(function()
	{// 全不选
		var aa = $(":checkbox[name='cm']");
		for (i = 0; i < aa.length; i++)
		{
			aa[i].checked = false;// 把对应项的checked属性设置为true
		}
	});

	$("#btn3").click(function()
	{// 反选
		var aa = $(":checkbox[name='cm']");
		for (i = 0; i < aa.length; i++)
		{
			if (aa[i].checked)
			{
				aa[i].checked = false;// 把对应项的checked属性设置为true
			} else
			{
				aa[i].checked = true;
			}
		}
	});

	$("#check").click(function()
	{// 全选 或全不选
		var aa = $(":checkbox[name='cm']");
		if ($("#check").attr("checked"))
		{
			for (i = 0; i < aa.length; i++)
			{
				aa[i].checked = true;// 把对应项的checked属性设置为true
			}
		} else
		{
			for (i = 0; i < aa.length; i++)
			{
				aa[i].checked = false;// 把对应项的checked属性设置为true
			}
		}
	});

	$("#btndelsel").click(function()
	{// 删除所选
		var aa = $(":checkbox[name='cm']");// cm名的复选框
		var del = "";
		for (i = 0; i < aa.length; i++)
		{
			if (aa[i].checked)
			{
				del += "," + aa[i].value;
			}
		}
		if (del == "")
		{
			alert("请至少选择1项");
		} else
		{
			if (confirm("确认删除这些选择项吗？" + del.substr(1)))
			{
				// substr从第1个开始取，下标从0开始
				location = "person/delall.do?id=" + del.substr(1);
			}
		}
	});
	$("#delone111").click(function()
	{// 删除所选1项
		var aa = $(":checkbox[name='cm']");
		var del = "";// 声明一个明变量
		a = 0;
		for (i = 0; i < aa.length; i++)
		{
			if (aa[i].checked)
			{
				del += "," + aa[i].value;
				a++;
			}
		}
		if (a > 1)
		{
			alert("本删除只能一次删除1项");
		} else if (del == "")
		{
			alert("请选择1项!!!");
		} else
		{
			if (confirm("确认删除此选项吗？" + del.substring(1)))
			{// 从第2个位置取
				window.location = "person/del.do?id=" + del.substring(1);// 将交给服务端去删除
			}
		}
	});
});